package com.example.hexagonal.infrastructure.input.rest;

import com.example.hexagonal.application.dto.request.ObjectRequestDto;
import com.example.hexagonal.application.dto.response.ObjectResponseDto;
import com.example.hexagonal.application.handler.IObjectHandler;
import com.example.hexagonal.application.security.JWTUtil;
import com.example.hexagonal.infrastructure.UserfeignClient.BearerHeader;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/object")
@RequiredArgsConstructor
public class ObjectRestController {


    private final JWTUtil jwtUtil;

    private final IObjectHandler objectHandler;

    @Operation(summary = "Add a new object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> saveObject(@RequestBody ObjectRequestDto objectRequestDto) {
        objectHandler.saveObject(objectRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all objects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ObjectResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })

    //// ESTE ES EL QUE ESTÁ FUNCIONANDO
    @GetMapping("/")
    public ResponseEntity<List<ObjectResponseDto>> getAllObjects(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader) {

        //Ojo Eduardo aquí recibe el Token que viene del otro Microservicio
        System.out.println("Authorization enviada desde el otro servicio:"+bearerHeader.toString());
        String token=bearerHeader.toString().substring(7);
        System.out.println("Token:'"+token+"'");
        try{
            String username=jwtUtil.extractUsername(token);
            System.out.println("usuario:"+username);
            //SecurityContextHolder.getContext().setAuthentication(token);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(objectHandler.getAllObjects(),HttpStatus.OK);
    }

    @GetMapping(
            path = "/pruebaheader",
            produces = MediaType.APPLICATION_JSON_VALUE
        )
    String getData(@RequestHeader(HttpHeaders.AUTHORIZATION) BearerHeader bearerHeader) {
        System.out.println(bearerHeader.toString());
        System.out.println(jwtUtil.extractUsernamefromToken(bearerHeader.toString()));
        boolean validar = jwtUtil.isTokenExpired(bearerHeader.toString());
        System.out.println("Token Validado:"+validar);
        return null;
    }


}