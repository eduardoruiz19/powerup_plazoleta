package com.example.hexagonal.infrastructure.UserfeignClient;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


@FeignClient(value="feingDemo",url = "http://localhost:8081/api/v1/user",configuration = FeignClientConfig.class)
@Headers("llegan Headers Authorization: {Authorization}")
public interface FeingServiceUtil {
    @GetMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> getUsers() ;

    @GetMapping(value = "/list",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> getUsers2(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization );
    @GetMapping(
            path = "/endpoint1",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    String getData(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader);

    @GetMapping(
            path = "/getuser",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    UserDto getUserByEmail(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader);

    @GetMapping("/{id}")
    UserDto getUserdataById(
            @PathVariable(value = "id") final Long id
            ,@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerHeader
    );

    @GetMapping(value = "/getuserdata",consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDto getUserToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization );

}
