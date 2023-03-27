package demo.controller;

import demo.domain.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class htmlController {

    private final UserService userService;

    @Autowired
    public htmlController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/deletes")
    public String deletes() {
        return "delete";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    @PostMapping("/registers")
    public String insert(@RequestParam String userId, @RequestParam String userPass) {
        userService.insert(new User(userId, userPass));
        return "register";
    }

    @GetMapping(value = "/delete")
    public String delete() {
        userService.delete();
        return "delete";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/logins")
    public String login(@RequestParam String userId, @RequestParam String userPass) {
        User user = userService.login(new User(userId, userPass));
        if (user == null) return "register";
        else return "login";
    }
}
