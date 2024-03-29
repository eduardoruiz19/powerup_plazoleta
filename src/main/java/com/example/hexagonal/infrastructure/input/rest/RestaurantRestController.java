package com.example.hexagonal.infrastructure.input.rest;

import com.example.hexagonal.application.dto.request.RestaurantRequestDto;
import com.example.hexagonal.application.dto.response.RestaurantResponseDto;
import com.example.hexagonal.application.handler.IRestaurantHandler;
import com.example.hexagonal.application.security.JWTUtil;
import com.example.hexagonal.infrastructure.UserfeignClient.FeingServiceUtil;
import com.example.hexagonal.infrastructure.UserfeignClient.UserDto;
import com.example.hexagonal.infrastructure.exception.UserMustBeOwnerException;
import com.example.hexagonal.infrastructure.exception.UserNotExistException;
import com.example.hexagonal.infrastructure.exception.UserWithoutCredentialsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantRestController {

    @Autowired
    private FeingServiceUtil feingServiceUtil;
    private final JWTUtil jwtUtil;
    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new Restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Restaurant created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Restaurant already exists", content = @Content)
    })
    @PostMapping("/")
    
    public ResponseEntity<Void> saveRestaurant
            (@RequestBody RestaurantRequestDto restaurantRequestDto
            ,@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
        // obtener el usuarioActual del Token
        String userToken=jwtUtil.extractUsernamefromToken(authorization);
        System.out.println("userToken:"+userToken);
        //Verify User´s  Admin role
            UserDto userInToken= feingServiceUtil.getUserToken(authorization);
            System.err.println(userInToken.getApellido()+" "+userInToken.getRol());

        if(!userInToken.getRol().equals("ADMIN")) {
            throw new UserWithoutCredentialsException();

        }else {
            UserDto userOwner = feingServiceUtil.getUserdataById(restaurantRequestDto.getId_owner(), authorization);
            System.out.println("OWNER:"+userOwner.getRol()+" "+userOwner.getNombre());
            //Verify if Owner Exist
            if(userOwner!=null){
                if(userOwner.getRol().equals("OWNER")){
                    restaurantHandler.saveRestaurant(restaurantRequestDto);
                    return new ResponseEntity<>(HttpStatus.CREATED);
                }else{
                    throw new UserMustBeOwnerException();
                }
            }else{
                throw new UserNotExistException();
            }
        }



    }

    @Operation(summary = "Get all Restaurants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Restaurants returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestaurantResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantHandler.getAllRestaurants());
    }


    @Operation(summary = "Get all Restaurants with pagination and sorting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Restaurants returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RestaurantResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/pagination/{page}/{pageSize}")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurantsWithPagination(@PathVariable int page , @PathVariable int pageSize) {
        System.out.println("llega a page");
        return ResponseEntity.ok(restaurantHandler.getAllRestaurantsWithPagination(page,pageSize));
    }

}