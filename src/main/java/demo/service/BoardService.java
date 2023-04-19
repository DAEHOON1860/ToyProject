package demo.service;

import demo.domain.Board;
import demo.domain.comment;
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

    public void deleteBoard() {
        boardMapper.deleteBoard();
    }

    public void deleteBoardBySeq(int seq) {
        boardMapper.deleteBoardBySeq(seq);
    }

    public void updateBoard(String subject, String content, int seq) {
        boardMapper.updateBoard(subject, content, seq);
    }

    public List<comment> selectComment(int seq) {
        return boardMapper.selectComment(seq);
    }

    public void registerComment(int seq, String id, String content) {
        boardMapper.registerComment(seq, id, content);
    }
}
