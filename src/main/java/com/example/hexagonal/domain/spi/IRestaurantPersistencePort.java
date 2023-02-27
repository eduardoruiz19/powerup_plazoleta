package com.example.hexagonal.domain.spi;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.domain.model.RestaurantModel;

import java.util.List;


/*  PUERTO DE PERSISTENCIA */
public interface IRestaurantPersistencePort {
    RestaurantModel saveRestaurant(RestaurantModel restaurantModel);

    List<RestaurantModel> getAllRestaurants();
    RestaurantModel getRestaurantByRestaurant_id(long id);
}