package com.example.hexagonal.infrastructure.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value="feingDemo",url = "http://localhost:8081/api/v1/user",configuration = FeignClientConfig.class)
public interface FeingServiceUtil {
    @GetMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> getUsers();

    @GetMapping(value = "/prueba",consumes = MediaType.APPLICATION_JSON_VALUE)
    String  getUser();

}
