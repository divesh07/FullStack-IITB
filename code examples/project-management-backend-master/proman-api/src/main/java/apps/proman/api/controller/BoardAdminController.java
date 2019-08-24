package apps.proman.api.controller;

import static apps.proman.api.controller.transformer.BoardTransformer.*;
import static apps.proman.api.data.ResourceConstants.BASE_URL;
import static apps.proman.service.user.exception.UserErrorCode.USR_008;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import apps.proman.api.controller.ext.ResponseBuilder;
import apps.proman.api.exception.RestException;
import apps.proman.api.model.BoardDetailsResponse;
import apps.proman.api.model.BoardOperationRequest;
import apps.proman.api.model.BoardOperationsRequest;
import apps.proman.api.model.BoardStatusType;
import apps.proman.api.model.BoardsSummaryResponse;
import apps.proman.api.model.CreateBoardRequest;
import apps.proman.api.model.CreateBoardResponse;
import apps.proman.api.model.UpdateBoardRequest;
import apps.proman.service.board.business.BoardService;
import apps.proman.service.board.entity.BoardEntity;
import apps.proman.service.board.exception.BoardErrorCode;
import apps.proman.service.board.model.BoardStatus;
import apps.proman.service.common.exception.ApplicationException;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.business.UserService;
import apps.proman.service.user.entity.UserEntity;
import apps.proman.service.user.exception.UserErrorCode;
import apps.proman.service.user.model.UserStatus;

@RestController
@CrossOrigin
@RequestMapping(BASE_URL)
public class BoardAdminController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/boards", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BoardsSummaryResponse> getBoards(@RequestHeader("authorization") String accessToken,
                                                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                                           @RequestParam(value = "limit", required = false, defaultValue = "10") int limit,
                                                           @RequestParam(value = "status", required = false) String status) {
        final SearchResult<BoardEntity> searchResult;
        if (StringUtils.isEmpty(status)) {
            searchResult = boardService.findBoards(page, limit);
        } else {
            searchResult = boardService.findBoards(BoardStatus.valueOf(toEnum(status).name()), page, limit);
        }
        return ResponseBuilder.ok().payload(toBoardsSummaryResponse(page, limit, searchResult)).build();
    }

    @RequestMapping(method = GET, path = "/boards/{id}", produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<BoardDetailsResponse> getBoard(@RequestHeader("authorization") String accessToken,
                                                         @PathVariable("id") final String boardUuid)
            throws ApplicationException {

        final BoardEntity boardEntity = boardService.findBoard(boardUuid);
        return ResponseBuilder.ok().payload(toBoardDetailsResponse(boardEntity)).build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/boards", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CreateBoardResponse> createBoard(@RequestHeader("authorization") String accessToken,
                                                           @RequestBody final CreateBoardRequest createBoardRequest) throws ApplicationException {

        UserEntity userEntity = userService.findUserByUuid(createBoardRequest.getOwnerId().toString());
        if (userEntity == null) {
            throw new ApplicationException(UserErrorCode.USR_001, createBoardRequest.getOwnerId().toString());
        } else if (!UserStatus.ACTIVE.equals(UserStatus.get(userEntity.getStatus()))) {
            throw new ApplicationException(UserErrorCode.USR_008, UserStatus.get(userEntity.getStatus()));
        }

        final BoardEntity boardEntity = toEntity(createBoardRequest);
        boardEntity.setOwner(userEntity);

        final BoardEntity createdBoard = boardService.createBoard(boardEntity);
        return ResponseBuilder.created().payload(toResponse(createdBoard)).build();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/boards/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity updateBoard(@RequestHeader("authorization") String accessToken,
                                      @PathVariable("id") final String boardUuid,
                                      @RequestBody final UpdateBoardRequest updatedBoardRequest) throws ApplicationException {

        final BoardEntity boardEntity = toEntity(updatedBoardRequest);
        if (updatedBoardRequest.getOwnerId() != null) {
            final UserEntity existingUser = userService.findUserByUuid(updatedBoardRequest.getOwnerId().toString());
            if (!UserStatus.ACTIVE.equals(UserStatus.get(existingUser.getStatus()))) {
                throw new ApplicationException(USR_008, UserStatus.get(existingUser.getStatus()));
            }
            boardEntity.setOwner(existingUser);
        }

        boardService.updateBoard(boardUuid, boardEntity);
        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/boards/{id}", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity patchBoard(@RequestHeader("authorization") String accessToken,
                                     @PathVariable("id") final String boardUuid,
                                     @RequestBody final BoardOperationsRequest boardOperationsRequest) throws ApplicationException {

        for (BoardOperationRequest boardOperationRequest : boardOperationsRequest) {
            boardService.changeBoardStatus(boardUuid, BoardStatus.valueOf(toEnum(boardOperationRequest.getValue()).name()));
        }

        return ResponseBuilder.ok().build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/boards/{id}")
    public ResponseEntity deleteBoard(@RequestHeader("authorization") String accessToken,
                                      @PathVariable("id") final String boardUuid) throws ApplicationException {
        boardService.deleteBoard(boardUuid);
        return ResponseBuilder.ok().build();
    }

    private BoardStatusType toEnum(final String status) {
        try {
            return BoardStatusType.valueOf(status);
        } catch (IllegalArgumentException exc) {
            throw new RestException(BoardErrorCode.BRD_003, StringUtils.join(BoardStatusType.values(), ","));
        }
    }

}
