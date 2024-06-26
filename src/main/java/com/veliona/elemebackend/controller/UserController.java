package com.veliona.elemebackend.controller;
import com.veliona.elemebackend.entity.User;
import com.veliona.elemebackend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/login")
    public void login (@RequestParam String uact, @RequestParam String upwd) {
        userService.login(uact, upwd);
    }
    @RequestMapping("register")
    public void register (@RequestBody User user) {
        userService.register(user);
    }
}
