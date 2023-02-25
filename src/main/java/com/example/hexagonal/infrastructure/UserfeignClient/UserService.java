package com.example.hexagonal.infrastructure.UserfeignClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final FeingServiceUtil client;
    public List<UserDto> getUsers(){
        return  client.getUsers();
    }

    public  String getUser(){
        return "ok";
    }
}
