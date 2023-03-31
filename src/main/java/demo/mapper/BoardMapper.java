package demo.mapper;

import demo.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardList();
    void registerBoard(Board board);

    Board selectBoard(int seq);

    void updateViews(int seq);
    void deleteBoard();
}
