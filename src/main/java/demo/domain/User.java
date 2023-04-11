package demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String userId; //아이디
    private String userPass; //패스워드
    private userPower power; //권한

    public User(String userId, String userPass, String name) {
        this.userId = userId;
        this.userPass = userPass;
        this.power = userPower.valueOf(name);
    }

    public User(String userId, String userPass) {
        this.userId = userId;
        this.userPass = userPass;
    }
}
