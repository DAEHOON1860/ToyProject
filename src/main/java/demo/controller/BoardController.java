package demo.controller;

import demo.domain.Board;
import demo.domain.User;
import demo.domain.comment;
import demo.service.BoardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static demo.domain.userPower.user;

@Controller
@SessionAttributes("user")
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
    public String registerBoard(@RequestParam String subject,
                                @RequestParam String content, @SessionAttribute(name = "user", required = false) User user) {
        boardService.registerBoard(new Board(user.getUserId(), subject, content, 0));
        return "index";
    }

    @GetMapping("/register/board")
    public String registerBoards(@SessionAttribute(name = "user", required = false) User user) {
        if (user == null) return "index";
        return "boardRegister";
    }

    @RequestMapping("/show/selectBoard")
    public String selectBoard(@RequestParam int seq, Model model, @SessionAttribute(name = "user", required = false) User user) {
        boardService.updateViews(seq);
        Board board = boardService.selectBoard(seq);
        if (!Objects.equals(user.getUserId(), board.getUserId())) return "index";
        List<comment> comment = boardService.selectComment(seq);
        model.addAttribute("board", board);
        model.addAttribute("comment", comment);
        return "selectBoard";
    }

    @GetMapping("/delete/board")
    public String deleteBoard() {
        boardService.deleteBoard();
        return "index";
    }

    @PostMapping("/delete/boardBySeq")
    public String deleteBoardBySeq(@RequestParam int seq) {
        boardService.deleteBoardBySeq(seq);
        return "index";
    }

    @GetMapping("/board/modify")
    public String boardModify(@RequestParam int seq, Model model) {
        Board board = boardService.selectBoard(seq);
        model.addAttribute("board", board);
        return "updateBoard";
    }

    @PostMapping("/board/update/{seq}")
    public String boardUpdate(@PathVariable("seq") int seq, @RequestParam String subject,
                              @RequestParam String content) {
        boardService.updateBoard(subject, content, seq);
        return "index";
    }

    @PostMapping("/registerComment")
    public String registerComment(@RequestParam int seq, @RequestParam String id, @RequestParam String content,
                                  Model model, @SessionAttribute(name = "user", required = false) User user) {
        boardService.registerComment(seq, id, content);
        boardService.updateViews(seq);
        Board board = boardService.selectBoard(seq);
        if (!Objects.equals(user.getUserId(), board.getUserId())) return "index";
        List<comment> comment = boardService.selectComment(seq);
        model.addAttribute("board", board);
        model.addAttribute("comment", comment);
        return "selectBoard";
    }
}
