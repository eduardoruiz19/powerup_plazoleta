package com.example.hexagonal.application.dto.response;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.OrderPlateModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlateResponseDto {
    private Long idPlate;

    private String name;

    private Long idCategory;

    private String description;

    private Long price;

    private RestaurantModel restaurantEntity;

    private String urlImage;

    private boolean active;
    private CategoryModel categoryEntity;

    private List<OrderPlateModel> orderPlateModelList;

}
