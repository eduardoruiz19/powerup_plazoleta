package com.example.hexagonal.application.dto.request;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.OrderPlateModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlateRequestDto {

    private Long idPlate;

    private String name;

    private Long idCategory;

    private String description;

    private Long price;

    private RestaurantModel restaurantModel;

    private String urlImage;

    private String active;
    private CategoryModel categoryModel;

    private List<OrderPlateModel> orderPlateModelList;

}
