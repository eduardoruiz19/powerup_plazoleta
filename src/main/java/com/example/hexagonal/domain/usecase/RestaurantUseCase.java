package com.example.hexagonal.domain.usecase;

import com.example.hexagonal.domain.api.IObjectServicePort;
import com.example.hexagonal.domain.api.IRestaurantServicePort;
import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import com.example.hexagonal.domain.spi.IObjectPersistencePort;
import com.example.hexagonal.domain.spi.IRestaurantPersistencePort;

import java.util.List;

public class RestaurantUseCase implements IRestaurantServicePort {

    /* APLICAR INYECCIÓN DE DEPENDENCIAS EN EL CONSTRUCTOR  -  NO USAR AUTOWIRED */
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort restaurantPersistencePort) {
        this.restaurantPersistencePort = restaurantPersistencePort;
    }

    @Override
    public void saveRestaurant(RestaurantModel restaurantModel) {
        restaurantPersistencePort.saveRestaurant(restaurantModel);
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        return restaurantPersistencePort.getAllRestaurants();
    }
}