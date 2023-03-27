package demo.controller;


import demo.domain.User;
import demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUserList(){
        return userService.getUserList();
    }
}
