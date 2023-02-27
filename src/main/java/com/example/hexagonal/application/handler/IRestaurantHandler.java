package com.example.hexagonal.application.handler;


import com.example.hexagonal.application.dto.request.ObjectRequestDto;
import com.example.hexagonal.application.dto.request.RestaurantRequestDto;
import com.example.hexagonal.application.dto.response.ObjectResponseDto;
import com.example.hexagonal.application.dto.response.RestaurantResponseDto;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.RestaurantModel;

import java.util.List;

public interface IRestaurantHandler {

    void saveRestaurant(RestaurantRequestDto restaurantRequestDto);

    List<RestaurantResponseDto> getAllRestaurants();

    RestaurantModel getRestaurantModelByRestaurant_id(Long idRestaurant);
}