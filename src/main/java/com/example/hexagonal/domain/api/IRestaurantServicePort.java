package com.example.hexagonal.domain.api;

import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.domain.model.RestaurantModel;

import java.util.List;


/* MÉTODOS QUE NOS INTERESA QUE EXPONGA NUESTRO DOMINIO  */
public interface IRestaurantServicePort {

    void saveRestaurant(RestaurantModel objectModel);

    List<RestaurantModel> getAllRestaurants();

    RestaurantModel getRestaurantByRestaurant_id(Long idRestaurant);
}