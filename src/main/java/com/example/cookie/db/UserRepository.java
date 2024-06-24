package com.example.cookie.db;

import com.example.cookie.model.UserDto;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserRepository {
    private List<UserDto> userDtoList = new ArrayList<>();

    @PostConstruct
    public void start(){
        userDtoList.add(
                new UserDto(
                        UUID.randomUUID().toString(),
                        "강수빈",
                        "1234"
                )
        );
        userDtoList.add(
                new UserDto(
                        UUID.randomUUID().toString(),
                        "사지은",
                        "1234"
                )
        );
        userDtoList.add(
                new UserDto(
                        UUID.randomUUID().toString(),
                        "홍석범",
                        "1234"
                )
        );
    }
}
