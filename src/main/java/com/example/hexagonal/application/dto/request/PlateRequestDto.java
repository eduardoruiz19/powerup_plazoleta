package com.example.hexagonal.application.dto.request;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.OrderPlateModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Setter
@Validated
public class PlateRequestDto {
    private Long idPlate;
    private String name;
    private String description;
    private Long price;
    private String urlImage;
    private boolean active;
    private Long idCategory;
    private Long id_restaurant;
    private CategoryModel categoryEntity;
    private RestaurantModel restaurantEntity;
    private List<OrderPlateModel> orderPlateModelList;
}
