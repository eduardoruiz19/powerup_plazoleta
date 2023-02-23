package com.example.hexagonal.application.handler.impl;

import com.example.hexagonal.application.dto.request.ObjectRequestDto;
import com.example.hexagonal.application.dto.request.RestaurantRequestDto;
import com.example.hexagonal.application.dto.response.ObjectResponseDto;
import com.example.hexagonal.application.dto.response.RestaurantResponseDto;
import com.example.hexagonal.application.handler.IObjectHandler;
import com.example.hexagonal.application.handler.IRestaurantHandler;
import com.example.hexagonal.application.mapper.IObjectRequestMapper;
import com.example.hexagonal.application.mapper.IObjectResponseMapper;
import com.example.hexagonal.application.mapper.IRestaurantRequestMapper;
import com.example.hexagonal.application.mapper.IRestaurantResponseMapper;
import com.example.hexagonal.domain.api.IObjectServicePort;
import com.example.hexagonal.domain.api.IRestaurantServicePort;
import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor //Crea los constructores para los atributos definidos como finales
@Transactional
public class RestaurantHandler implements IRestaurantHandler {

    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final IRestaurantResponseMapper restaurantResponseMapper;

    @Override
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        RestaurantModel restaurantModel = restaurantRequestMapper.toModel(restaurantRequestDto);
        restaurantServicePort.saveRestaurant(restaurantModel);
    }

    @Override
    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantResponseMapper.toResponseList(restaurantServicePort.getAllRestaurants());
    }
}