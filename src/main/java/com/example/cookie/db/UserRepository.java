package com.example.cookie.db;

import com.example.cookie.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepository {

    private final List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findById(String id){
        return userList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public Optional<UserDto> findByName(String name){
        return userList
                .stream()
                .filter(it ->it.getName().equals(name))
                .findFirst();
    }

    @PostConstruct
    public void start(){
        userList.add(
                new UserDto(
                        UUID.randomUUID().toString(), // 랜덤으로 만들어서 id가 중복되지 않게 만들어줌
                        "강수빈",
                        "1234"
                )
        );
        userList.add(
                new UserDto(
                        UUID.randomUUID().toString(),
                        "사지은",
                        "1234"
                )
        );
        userList.add(
                new UserDto(
                        UUID.randomUUID().toString(),
                        "홍석범",
                        "1234"
                )
        );
    }
}
