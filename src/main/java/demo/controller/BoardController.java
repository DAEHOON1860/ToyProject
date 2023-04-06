package demo.controller;

import demo.domain.Board;
import demo.domain.User;
import demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@SessionAttributes("user")
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/show/board")
    public String getBoardList(Model model, @SessionAttribute(name = "user", required = false) User user) {
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
    public String selectBoard(@RequestParam int seq, Model model, @SessionAttribute(name = "user", required = false) User user) {
        boardService.updateViews(seq);
        Board board = boardService.selectBoard(seq);
        if (!Objects.equals(user.getUserId(), board.getUserId())) return "index";
        model.addAttribute("board", board);
        return "selectBoard";
    }

    @GetMapping("/delete/board")
    public String deleteBoard() {
        boardService.deleteBoard();
        return "index";
    }
}
