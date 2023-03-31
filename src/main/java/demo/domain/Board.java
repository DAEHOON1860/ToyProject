package demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int seq; //글 번호
    private String userId; //글 작성자
    private String subject; // 글 제목
    private String content; // 글 본문
    private LocalDateTime date; // 글 작성일자
    private int views; // 글 조회수

    public Board(String userId, String subject, String content, int views) {
        this.userId = userId;
        this.subject = subject;
        this.content = content;
        this.views = views;
    }
}
