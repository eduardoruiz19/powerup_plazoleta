package com.example.hexagonal.infrastructure.UserfeignClient;

import com.example.hexagonal.application.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class UserFeignController {
    @Autowired
    private  JWTUtil jwtUtil;
    @Autowired
    private FeingServiceUtil feingServiceUtil;

    @GetMapping("/username")
    public String getUserName() {

        return feingServiceUtil.getUsers().toString();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(feingServiceUtil.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> someClassName(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {

         return ResponseEntity.ok().body(feingServiceUtil.getUsers2(bearerToken));

    }
    @GetMapping("/getusers")
    public ResponseEntity<?> getUserByEmail(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        String token=bearerToken.substring(7);
        String username=jwtUtil.extractUsername(token);
        return ResponseEntity.ok().body(feingServiceUtil.getUsers2(bearerToken));
        //return ResponseEntity.ok().body(feingServiceUtil.getUserByEmail(@RequestHeader BearerHeader bearerHeader);

    }



    /**
     * Retrieve user data from received token  send by Microservice Principal PowerUp
     * @param bearerToken the token received
     * @return user data in format JSON
     */

    /*
    @GetMapping("/getuserdata")
    public ResponseEntity<?> getUserByEmail2(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        String token=bearerToken.substring(7);
        String username=jwtUtil.extractUsername(token);

        UserDto received= feingServiceUtil.getUsers3(bearerToken);
        System.out.println("* * Rol Recibido:"+received.getRol());
        return ResponseEntity.ok().body(feingServiceUtil.getUsers3(bearerToken));
        //return ResponseEntity.ok().body(feingServiceUtil.getUserByEmail(@RequestHeader BearerHeader bearerHeader);

    }


     */

    @GetMapping("/getuserdata")
    public UserDto getUserByData(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        String token=bearerToken.substring(7);
        String username=jwtUtil.extractUsername(token);

        UserDto received= feingServiceUtil.getUserToken(bearerToken);
        System.out.println("* * nombre Recibido:"+received.getNombre());
        System.out.println("* * Rol Recibido:"+received.getRol());
        return received;
        //return ResponseEntity.ok().body(feingServiceUtil.getUsers3(bearerToken));
        //return ResponseEntity.ok().body(feingServiceUtil.getUserByEmail(@RequestHeader BearerHeader bearerHeader);

    }

    @GetMapping("/{id}")
    public UserDto getUserDataById(@PathVariable("id") Long id,@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        UserDto user = feingServiceUtil.getUserdataById(id, bearerToken);
        System.err.println(user.getApellido()+" "+user.getNombre());
        return  user;
    }

}
