package demo.controller;

import demo.domain.Board;
import demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/show/board")
    public String getBoardList(Model model) {
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "board";
    }

    @PostMapping("/register/boards")
    public String registerBoard(@RequestParam String userId, @RequestParam String subject,
                                @RequestParam String content, @RequestParam int views) {
        boardService.registerBoard(new Board(userId, subject, content, views));
        return "index";
    }

    @GetMapping("/register/board")
    public String registerBoards() {
        return "boardRegister";
    }

    @RequestMapping("/show/selectBoard")
    public String selectBoard(@RequestParam int seq, Model model) {
        boardService.updateViews(seq);
        Board board = boardService.selectBoard(seq);
        model.addAttribute("board", board);
        return "selectBoard";
    }

    @GetMapping("/delete/board")
    public String deleteBoard() {
        boardService.deleteBoard();
        return "index";
    }
}
