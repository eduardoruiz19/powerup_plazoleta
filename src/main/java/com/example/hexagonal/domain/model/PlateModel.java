package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.OrderPlateEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;

import javax.persistence.*;
import java.util.List;

public class PlateModel {

    private Long idPlate;

    private String name;

    private Long idCategory;

    private String description;

    private Long price;

    private RestaurantModel restaurantModel;

    private String urlImage;

    private String active;
    private List<CategoryModel> categoryModelList;

    private List<OrderPlateModel> orderPlateModelList;

}
