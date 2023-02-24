package com.example.hexagonal.infrastructure.feignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class FeignDemoController {
    @Autowired
    private  FeingServiceUtil feingServiceUtil;

    @GetMapping("/username")
    public String getUserName(){

        return feingServiceUtil.getUsers().toString();
    }
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAll(){
        return  new ResponseEntity<>(feingServiceUtil.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/endpoint")
    public ResponseEntity<String> someClassName(@RequestHeader("Authorization") String bearerToken) {

        System.out.println(bearerToken); // print out bearer token
        return  new ResponseEntity<>(bearerToken,HttpStatus.OK);
        //return  new ResponseEntity<>(feingServiceUtil.getUsers(), HttpStatus.OK);
        // some more code
    }
}
