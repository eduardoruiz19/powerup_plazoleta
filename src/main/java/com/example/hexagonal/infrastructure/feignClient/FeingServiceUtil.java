package com.example.hexagonal.infrastructure.feignClient;

import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@FeignClient(value="feingDemo",url = "http://localhost:8081/api/v1/user",configuration = FeignClientConfig.class)
@Headers("llegan Headers Authorization: {authorization}")
public interface FeingServiceUtil {
    @GetMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> getUsers() ;

    @GetMapping(
            path = "/endpoint1",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    String getData(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader);

}
