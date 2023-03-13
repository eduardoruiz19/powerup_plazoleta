package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.OrderPlateEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import com.example.hexagonal.domain.exception.DomainException;
import javax.persistence.*;
import java.util.List;

public class PlateModel {
    private Long idPlate;
    private String name;
    private String description;
    private Long price;
    private String urlImage;
    private boolean active;
    private Long idCategory;
    private Long idRestaurant;
    private RestaurantModel restaurantEntity;
    private CategoryEntity categoryEntity;

    private List<OrderPlateModel> orderPlateModelList;


    public PlateModel() {
    }

    public Long getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(Long idPlate) {
        this.idPlate = idPlate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {

        if(price>0){
            this.price = price;
        }else{
            throw new DomainException("Price is not Valid");
        }

    }

    public RestaurantModel getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantModel restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public List<OrderPlateModel> getOrderPlateModelList() {
        return orderPlateModelList;
    }

    public void setOrderPlateModelList(List<OrderPlateModel> orderPlateModelList) {
        this.orderPlateModelList = orderPlateModelList;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
}
