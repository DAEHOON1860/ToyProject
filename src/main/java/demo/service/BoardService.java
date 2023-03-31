package demo.service;

import demo.domain.Board;
import demo.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Repository
public class BoardService {

    private final BoardMapper boardMapper;

    public List<Board> getBoardList() {
        return boardMapper.getBoardList();
    }

    public void registerBoard(Board board) {
        boardMapper.registerBoard(board);
    }

    public Board selectBoard(int seq) {
        return boardMapper.selectBoard(seq);
    }

    public void updateViews(int seq) {
        boardMapper.updateViews(seq);
    }
    public void deleteBoard(){boardMapper.deleteBoard();}
}
