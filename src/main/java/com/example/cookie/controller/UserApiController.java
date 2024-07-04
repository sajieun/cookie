package com.example.cookie.controller;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest httpServletRequest,
            @CookieValue(name = "authorization-cookie", required = false) // 쿠키를 직접 받는 방법
            String authorizationCookie
    ){
        log.info("authorizationCookie : {}", authorizationCookie);
        var optionalUserDto = userRepository.findById(authorizationCookie);
        return optionalUserDto.get();

/*        var cookies = httpServletRequest.getCookies();
        if (cookies != null){
            for (Cookie cookie: cookies){
                log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
            }
        }*/

    }

    @GetMapping("/me2")
    public UserDto me2(
            HttpServletRequest httpServletRequest,
            @RequestHeader(name = "authorization", required = false) // 쿠키를 직접 받는 방법
            String authorizationHeader
    ) {
        log.info("authorizationHeader : {}", authorizationHeader);
        var optionalUserDto = userRepository.findById(authorizationHeader);
        return optionalUserDto.get();
    }
}
