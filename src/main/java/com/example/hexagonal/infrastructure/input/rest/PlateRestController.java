package com.example.hexagonal.infrastructure.input.rest;

import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.request.PlateRequestDto;
import com.example.hexagonal.application.dto.response.PlateResponseDto;
import com.example.hexagonal.application.handler.ICategoryHandler;
import com.example.hexagonal.application.handler.IPlateHandler;
import com.example.hexagonal.application.handler.IRestaurantHandler;
import com.example.hexagonal.application.mapper.IPlateRequestMapper;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import com.example.hexagonal.infrastructure.UserfeignClient.FeingServiceUtil;
import com.example.hexagonal.infrastructure.UserfeignClient.UserDto;
import com.example.hexagonal.infrastructure.exception.*;
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

    private final IPlateRequestMapper plateRequestMapper;
    private final ICategoryHandler categoryHandler;


    private final IRestaurantHandler restaurantHandler;

    @Operation(summary = "Add a new Plate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plate created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Plate already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> savePlate(@RequestBody PlateRequestDto plateRequestDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {


        UserDto userDto = feingServiceUtil.getUserToken(bearerToken);
        if (!userDto.getRol().equals("OWNER")) {
            throw new UserMustBeOwnerException();
        }
        plateRequestDto.setActive(true);
        CategoryModel categoryModel = categoryHandler.getCategoryModelByCategory_id(plateRequestDto.getIdCategory());
        if (categoryModel == null) {
            throw new CategoryNotExistException();
        }
        plateRequestDto.setCategoryEntity(categoryModel);
        RestaurantModel restaurantModel = restaurantHandler.getRestaurantModelByRestaurant_id(plateRequestDto.getId_restaurant());
        if (restaurantModel == null) {
            throw new RestaurantNotExistException();
        }
        plateRequestDto.setRestaurantEntity(restaurantModel);

        plateHandler.savePlate(plateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Operation(summary = "Edit Plate's Price and Description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Plate Edited", content = @Content),
            @ApiResponse(responseCode = "404", description = "Plate Not Found", content = @Content)
    })
    @PutMapping("/")
    public ResponseEntity<Void> updatePlate(@RequestBody PlateRequestDto plateRequestDto, @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {

        UserDto userDto = feingServiceUtil.getUserToken(bearerToken);
        if (!userDto.getRol().equals("OWNER")) {
            throw new UserMustBeOwnerException();
        }

        PlateModel plate = plateHandler.getPlateById(plateRequestDto.getIdPlate());
        if (plate == null) {
            throw new PlateNotExistException();
        }
        plate.setPrice(plateRequestDto.getPrice());
        plate.setDescription(plateRequestDto.getDescription());

        PlateRequestDto plateEdit = plateRequestMapper.toPlateRequestDto(plate);
        plateHandler.savePlate(plateEdit);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Disable Plate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plate Disabled", content = @Content),
            @ApiResponse(responseCode = "404", description = "Plate Not Found", content = @Content)
    })
    @PutMapping("/disable/{id}")
    public ResponseEntity<Void> disablePlate(
            @PathVariable long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        System.out.println("Id:" + id);

        UserDto userDto = feingServiceUtil.getUserToken(bearerToken);
        if (!userDto.getRol().equals("OWNER")) {
            throw new UserMustBeOwnerException();
        }

        PlateModel plate = plateHandler.getPlateById(id);
        if (plate == null) {
            throw new NoDataFoundException();
        }
        RestaurantModel restaurantPlate = plate.getRestaurantEntity();

        System.out.println("plate id_restaurant:" + restaurantPlate.getIdRestaurant());
        RestaurantModel restaurantModel = restaurantHandler.getRestaurantModelByRestaurant_id(restaurantPlate.getIdRestaurant());
        if (restaurantModel.getId_owner() != userDto.getId()) {
            throw new UserMustBeOwnerException();
        }
        plate.setActive(false);
        PlateRequestDto plateEdit = plateRequestMapper.toPlateRequestDto(plate);
        plateHandler.savePlate(plateEdit);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Enable Plate")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plate Disabled", content = @Content),
            @ApiResponse(responseCode = "404", description = "Plate Not Found", content = @Content)
    })
    @PutMapping("/enable/{id}")
    public ResponseEntity<Void> enablePlate(
            @PathVariable long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        System.out.println("Id:" + id);

        UserDto userDto = feingServiceUtil.getUserToken(bearerToken);
        if (!userDto.getRol().equals("OWNER")) {
            throw new UserMustBeOwnerException();
        }

        PlateModel plate = plateHandler.getPlateById(id);
        if (plate == null) {
            throw new NoDataFoundException();
        }
        RestaurantModel restaurantPlate = plate.getRestaurantEntity();

        System.out.println("plate id_restaurant:" + restaurantPlate.getIdRestaurant());
        RestaurantModel restaurantModel = restaurantHandler.getRestaurantModelByRestaurant_id(restaurantPlate.getIdRestaurant());
        if (restaurantModel.getId_owner() != userDto.getId()) {
            throw new UserMustBeOwnerException();
        }
        plate.setActive(true);
        PlateRequestDto plateEdit = plateRequestMapper.toPlateRequestDto(plate);
        plateHandler.savePlate(plateEdit);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Get all Plates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Plates returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = PlateResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<PlateResponseDto>> getAllPlates(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        UserDto userDto = feingServiceUtil.getUserToken(bearerToken);
        System.out.println("userdto:" + userDto.getNombre() + " " + userDto.getRol());
        System.out.println();
        return ResponseEntity.ok(plateHandler.getAllPlates());
    }

    @GetMapping("/paged/{id}")
    public ResponseEntity<List<PlateResponseDto>> getAllPlatesPaged(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        UserDto userDto = feingServiceUtil.getUserToken(bearerToken);
        System.out.println("userdto:" + userDto.getNombre() + " " + userDto.getRol());
        System.out.println();
        return ResponseEntity.ok(plateHandler.getAllPlates());
    }


}