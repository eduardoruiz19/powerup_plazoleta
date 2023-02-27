package com.example.hexagonal.infrastructure.input.rest;

import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.request.PlateRequestDto;
import com.example.hexagonal.application.dto.response.PlateResponseDto;
import com.example.hexagonal.application.handler.ICategoryHandler;
import com.example.hexagonal.application.handler.IPlateHandler;
import com.example.hexagonal.application.handler.IRestaurantHandler;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import com.example.hexagonal.infrastructure.UserfeignClient.FeingServiceUtil;
import com.example.hexagonal.infrastructure.UserfeignClient.UserDto;
import com.example.hexagonal.infrastructure.exception.CategoryNotExistException;
import com.example.hexagonal.infrastructure.exception.RestaurantNotExistException;
import com.example.hexagonal.infrastructure.exception.UserMustBeOwnerException;
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
@RequestMapping("/api/v1/plate")
@RequiredArgsConstructor
public class PlateRestController {

    @Autowired
    private FeingServiceUtil feingServiceUtil;

    private final IPlateHandler plateHandler;
    private final ICategoryHandler categoryHandler;
    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new Plate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plate created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Plate already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> savePlate(@RequestBody PlateRequestDto plateRequestDto,@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {



            UserDto userDto = feingServiceUtil.getUserToken(bearerToken);
            if (!userDto.getRol().equals("OWNER")) {
                throw new UserMustBeOwnerException();
            }
            plateRequestDto.setActive("ACTIVO");
            CategoryModel categoryModel = categoryHandler.getCategoryModelByCategory_id(plateRequestDto.getIdCategory());
            if(categoryModel==null){
                throw new CategoryNotExistException();
            }
            plateRequestDto.setCategoryEntity(categoryModel);
            RestaurantModel restaurantModel = restaurantHandler.getRestaurantModelByRestaurant_id(plateRequestDto.getId_restaurant());
            if(restaurantModel==null){
                throw new RestaurantNotExistException();
            }
            plateRequestDto.setRestaurantEntity(restaurantModel);

            plateHandler.savePlate(plateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Plates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Plates returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlateResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<PlateResponseDto>> getAllPlates(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
    UserDto userDto= feingServiceUtil.getUserToken(bearerToken);
        System.out.println("userdto:"+userDto.getNombre()+" "+userDto.getRol());
        System.out.println();
        return ResponseEntity.ok(plateHandler.getAllPlates());
    }


}