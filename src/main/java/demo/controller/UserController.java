package demo.controller;


import demo.domain.User;
import demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/api/v1/user")
    public String getUserList(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "listLoof";
    }
}
