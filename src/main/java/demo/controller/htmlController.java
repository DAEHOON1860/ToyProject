package demo.controller;

import demo.domain.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class htmlController {

    private final UserService userService;

    @Autowired
    public htmlController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String register() {
        return "register";
    }

    @PostMapping("/registers")
    public String insert(@RequestParam String userId, @RequestParam String userPass, @RequestParam String power) {
        userService.insert(new User(userId, userPass, power));
        return "login";
    }

    @GetMapping(value = "/delete")
    public String delete() {
        userService.delete();
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/logins")
    public String login(@ModelAttribute("user") User user,
                        @RequestParam String userId, @RequestParam String userPass,
                        SessionStatus sessionStatus) {
        user = userService.login(new User(userId, userPass));
        if (user == null) {
            sessionStatus.setComplete();
            return "register";
        } else {
            return "index";
        }
    }

    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }
}
