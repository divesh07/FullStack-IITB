package apps.proman.api.controller.transformer;

import java.util.UUID;

import apps.proman.api.model.BoardDetailsResponse;
import apps.proman.api.model.BoardOwnerDetailsType;
import apps.proman.api.model.BoardOwnerType;
import apps.proman.api.model.BoardStatusType;
import apps.proman.api.model.BoardSummaryType;
import apps.proman.api.model.BoardsSummaryResponse;
import apps.proman.api.model.CreateBoardRequest;
import apps.proman.api.model.CreateBoardResponse;
import apps.proman.api.model.UpdateBoardRequest;
import apps.proman.service.board.entity.BoardEntity;
import apps.proman.service.board.model.BoardStatus;
import apps.proman.service.common.model.SearchResult;
import apps.proman.service.user.entity.UserEntity;

public final class BoardTransformer {

    private BoardTransformer() {
    }

    public static BoardEntity toEntity(final CreateBoardRequest boardRequest) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(boardRequest.getName());
        boardEntity.setDescription(boardRequest.getDescription());
        return boardEntity;
    }

    public static BoardEntity toEntity(final UpdateBoardRequest boardRequest) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(boardRequest.getName());
        boardEntity.setDescription(boardRequest.getDescription());
        return boardEntity;
    }

    public static CreateBoardResponse toResponse(final BoardEntity boardEntity) {
        return new CreateBoardResponse().id(UUID.fromString(boardEntity.getUuid()))
                .status(toStatus(boardEntity.getStatus()));
    }

    public static BoardsSummaryResponse toBoardsSummaryResponse(final int page, final int limit, final SearchResult<BoardEntity> searchResult) {

        BoardsSummaryResponse usersSummaryResponse = new BoardsSummaryResponse().totalCount(searchResult.getTotalCount()).page(page).limit(limit);

        for(BoardEntity entity : searchResult.getPayload()) {
            BoardSummaryType summaryType = new BoardSummaryType().id(UUID.fromString(entity.getUuid()))
                    .name(entity.getName()).description(entity.getDescription()).owner(toOwner(entity.getOwner()))
                    .status(toStatus(entity.getStatus()));
            usersSummaryResponse.addBoardsItem(summaryType);
        }
        return usersSummaryResponse;
    }

    public static BoardDetailsResponse toBoardDetailsResponse(BoardEntity entity) {
        return new BoardDetailsResponse().id(UUID.fromString(entity.getUuid()))
                .name(entity.getName()).description(entity.getDescription()).owner(toOwnerDetails(entity.getOwner()))
                .status(toStatus(entity.getStatus()))
                .totalProjects(entity.getProjects().size());
    }

    private static BoardOwnerType toOwner(final UserEntity owner) {
        return new BoardOwnerType().id(UUID.fromString(owner.getUuid())).firstName(owner.getFirstName()).lastName(owner.getLastName());
    }

    private static BoardOwnerDetailsType toOwnerDetails(final UserEntity owner) {
        return new BoardOwnerDetailsType().id(UUID.fromString(owner.getUuid())).firstName(owner.getFirstName())
                    .lastName(owner.getLastName()).emailAddress(owner.getEmail())
                    .role(RoleTransformer.toRoleType(owner.getRole()));
    }

    private static BoardStatusType toStatus(final int statusCode) {
        return BoardStatusType.valueOf(BoardStatus.get(statusCode).name());
    }

}
