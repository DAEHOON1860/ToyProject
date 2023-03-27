package demo.domain;

import lombok.Data;

@Data
public class User {
    String userId;
    String userPass;
    public User(String userId, String userPass){
        this.userId = userId;
        this.userPass = userPass;
    }
}
