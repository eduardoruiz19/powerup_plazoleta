package com.example.hexagonal.infrastructure.input.rest;

import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.application.dto.response.ObjectResponseDto;
import com.example.hexagonal.application.handler.ICategoryHandler;
import com.example.hexagonal.infrastructure.UserfeignClient.FeingServiceUtil;
import com.example.hexagonal.infrastructure.UserfeignClient.UserDto;
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
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryRestController {

    @Autowired
    private FeingServiceUtil feingServiceUtil;

    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Add a new Category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content)
    })
    @PostMapping("/")
    
    public ResponseEntity<Void> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        categoryHandler.saveCategory(categoryRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "Get all Categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Categories returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ObjectResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
    UserDto userDto= feingServiceUtil.getUserToken(bearerToken);
        System.out.println("userdto:"+userDto.getNombre());
        return ResponseEntity.ok(categoryHandler.getAllCategories());
    }


    @Operation(summary = "Get all Categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Categories returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ObjectResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/createCategory")
    public ResponseEntity<List<CategoryResponseDto>> getAllToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        UserDto userDto= feingServiceUtil.getUserToken(bearerToken);
        System.out.println("userdto:"+userDto.getNombre());
        return ResponseEntity.ok(categoryHandler.getAllCategories());
    }

}