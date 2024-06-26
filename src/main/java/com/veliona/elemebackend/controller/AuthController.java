package com.veliona.elemebackend.controller;

import com.veliona.elemebackend.entity.User;
import com.veliona.elemebackend.service.UserService;
import com.veliona.elemebackend.utils.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.veliona.elemebackend.utils.JwtUtil.generateToken;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    private final String SECRET_KEY = "your_secret_key";

    @PostMapping("/login")
    public String login(@RequestParam String uact, @RequestParam String upwd) {
        String msg = userService.login(uact, upwd);
        if ("success".equals(msg)) {
            String token = generateToken(uact);
            JsonResponse json = new JsonResponse(true, token, "Login success");
            return json.toString();
        } else {
            JsonResponse json = new JsonResponse(false, "Login failed");
            return json.toString();
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        String msg = userService.register(user);
        if ("success".equals(msg)) {
            JsonResponse json = new JsonResponse(true, "Registration success");
            return json.toString();
        } else {
            JsonResponse json = new JsonResponse(false, "Registration failed");
            return json.toString();
        }
    }


}
