package apps.proman.service.board.dao;

import javax.validation.constraints.NotNull;

import apps.proman.service.board.entity.BoardEntity;
import apps.proman.service.board.model.BoardStatus;
import apps.proman.service.common.dao.BaseDao;
import apps.proman.service.common.model.SearchResult;

public interface BoardDao extends BaseDao<BoardEntity> {

    SearchResult<BoardEntity> find(@NotNull Integer page, @NotNull Integer limit);

    SearchResult<BoardEntity> find(@NotNull BoardStatus boardStatus, @NotNull Integer page, @NotNull Integer limit);

    BoardEntity findByName(@NotNull String boardName);

}
