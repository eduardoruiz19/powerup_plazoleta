package com.example.hexagonal.infrastructure.input.rest;

import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.application.dto.response.ObjectResponseDto;
import com.example.hexagonal.application.dto.response.PlateResponseDto;
import com.example.hexagonal.application.dto.response.RestaurantResponseDto;
import com.example.hexagonal.application.handler.ICategoryHandler;
import com.example.hexagonal.domain.model.PlateModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import com.example.hexagonal.infrastructure.UserfeignClient.FeingServiceUtil;
import com.example.hexagonal.infrastructure.UserfeignClient.UserDto;
import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import com.example.hexagonal.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.repository.ICategoryRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryRestController {

    @Autowired
    private FeingServiceUtil feingServiceUtil;

    private final ICategoryHandler categoryHandler;

    private final ICategoryRepository categoryRepository;

    private final ICategoryEntityMapper categoryMapper;

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
                            array = @ArraySchema(schema = @Schema(implementation = CategoryResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
    UserDto userDto= feingServiceUtil.getUserToken(bearerToken);
        System.out.println("userdto:"+userDto.getNombre());
        return ok(categoryHandler.getAllCategories());
    }


    /*
    @Operation(summary = "Get all Categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Categories returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = ObjectResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })



    @GetMapping("/restaurant/{restaurant_id}/{page}/{pageSize}")
    public ResponseEntity<List<CategoryResponseDto>> getPlatesByRestaurant_id(@PathVariable long pageSize,@PathVariable long page,@PathVariable long restaurant_id,@RequestHeader(HttpHeaders.AUTHORIZATION) String bearerToken) {
        UserDto userDto= feingServiceUtil.getUserToken(bearerToken);
        System.out.println("Id:" + restaurant_id);
        System.out.println("userdto:"+userDto.getNombre());
        List<CategoryResponseDto> listaTotal = categoryHandler.getAllCategoriesByRestaurant_id(restaurant_id,page,pageSize);
        List <CategoryResponseDto> listaFiltrada= new ArrayList<>();

        try {


            for (int i = 0; i < listaTotal.size(); i++) {
                CategoryResponseDto categoria = listaTotal.get(i);
                CategoryResponseDto categoriaNueva = new CategoryResponseDto();
                categoriaNueva.setIdCategory(categoria.getIdCategory());
                categoriaNueva.setName(categoria.getName());
                categoriaNueva.setDescription(categoria.getDescription());



                List<PlateModel> listaPlatos = categoria.getPlateEntityList();
                List<PlateModel> listaPlatosFiltrada = new ArrayList<>();
                for (int j = 0; j < listaPlatos.size(); j++) {

                    PlateModel plato = listaPlatos.get(j);
                    RestaurantModel restaurante = plato.getRestaurantEntity();

                    if (restaurante.getIdRestaurant() == restaurant_id && plato.getActive()) {
                        PlateModel plato2 = new PlateModel();
                        plato2.setCategoryEntity(null);
                        plato2.setIdCategory(plato.getIdCategory());
                        plato2.setActive(plato.getActive());
                        plato2.setName(plato.getName());
                        plato2.setDescription(plato.getDescription());
                        plato2.setPrice(plato.getPrice());
                        plato2.setIdPlate(plato.getIdPlate());
                        plato2.setIdRestaurant(plato.getIdRestaurant());
                        plato2.setOrderPlateModelList(null);
                        plato2.setUrlImage(plato.getUrlImage());

                        listaPlatosFiltrada.add(plato2);

                    }
                }
                categoriaNueva.setPlateEntityList(listaPlatosFiltrada);
                listaFiltrada.add(categoriaNueva);

                System.out.println("pagina:"+page+" pageSize:"+pageSize);
                if(page<1){
                    page=1;
                }
                page--;
                Pageable sortedByName =
                        PageRequest.of((int) page, (int) pageSize, Sort.by("name").ascending());



                //Page<CategoryEntity> allCategories = categoryRepository.findAllWithPagination();
                //Page<CategoryResponseDto> paginaCategoria=
                //List<CategoryResponseDto> categoryEntitiesEntityList = allCategories.getContent();
                //return categoryMapper.toRestaurantModelList(restaurantEntityList);
                //return categoryMapper.toCategoryModelList(categoryEntitiesEntityList);


            }
        }catch (Exception e){
            e.printStackTrace();
        }

            return ok(listaFiltrada);

    }
    */


}