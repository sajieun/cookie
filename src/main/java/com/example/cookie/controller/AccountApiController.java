package com.example.cookie.controller;

import com.example.cookie.model.LoginRequest;
import com.example.cookie.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApiController {

    private final UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse,
            HttpSession httpSession
    ){
        return userService.login(loginRequest,httpServletResponse);
    }
}
