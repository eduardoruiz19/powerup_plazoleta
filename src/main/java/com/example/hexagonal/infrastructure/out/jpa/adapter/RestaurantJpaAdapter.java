package com.example.hexagonal.infrastructure.out.jpa.adapter;

import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import com.example.hexagonal.domain.spi.IObjectPersistencePort;
import com.example.hexagonal.domain.spi.IRestaurantPersistencePort;
import com.example.hexagonal.infrastructure.exception.NoDataFoundException;
import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import com.example.hexagonal.infrastructure.out.jpa.mapper.IObjectEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.repository.IObjectRepository;
import com.example.hexagonal.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@RequiredArgsConstructor
public class RestaurantJpaAdapter implements IRestaurantPersistencePort {

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;


    @Override
    public RestaurantModel saveRestaurant(RestaurantModel restaurantModel) {
        RestaurantEntity restaurantEntity = restaurantRepository.save(restaurantEntityMapper.toEntity(restaurantModel));
        return restaurantEntityMapper.toRestaurantModel(restaurantEntity);
    }

    @Override
    public List<RestaurantModel> getAllRestaurants() {
        List<RestaurantEntity> entityList = restaurantRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return restaurantEntityMapper.toRestaurantModelList(entityList);
    }

    @Override
    public RestaurantModel getRestaurantByRestaurant_id(long id) {
        RestaurantEntity restaurantEntity = restaurantRepository.findByIdRestaurant(id);
        return restaurantEntityMapper.toRestaurantModel(restaurantEntity);
    }

    @Override
    public List<RestaurantModel> getAllRestaurantsWithPagination(int page, int pageSize) {
        System.out.println("pagina:"+page+" pageSize:"+pageSize);
        if(page<1){
            page=1;
        }
        page--;
        Pageable sortedByName =
                PageRequest.of(page, pageSize, Sort.by("name").ascending());



        Page<RestaurantEntity> allRestaurants = restaurantRepository.findAll(sortedByName);

        List<RestaurantEntity> restaurantEntityList = allRestaurants.getContent();
        return restaurantEntityMapper.toRestaurantModelList(restaurantEntityList);
    }

}