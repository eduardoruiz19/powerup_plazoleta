package com.example.hexagonal.infrastructure.configuration;

import com.example.hexagonal.domain.api.ICategoryServicePort;
import com.example.hexagonal.domain.api.IObjectServicePort;
import com.example.hexagonal.domain.api.IRestaurantServicePort;
import com.example.hexagonal.domain.spi.ICategoryPersistencePort;
import com.example.hexagonal.domain.spi.IObjectPersistencePort;
import com.example.hexagonal.domain.spi.IRestaurantPersistencePort;
import com.example.hexagonal.domain.usecase.CategoryUseCase;
import com.example.hexagonal.domain.usecase.ObjectUseCase;
import com.example.hexagonal.domain.usecase.RestaurantUseCase;
import com.example.hexagonal.infrastructure.out.jpa.adapter.CategoryJpaAdapter;
import com.example.hexagonal.infrastructure.out.jpa.adapter.ObjectJpaAdapter;
import com.example.hexagonal.infrastructure.out.jpa.adapter.RestaurantJpaAdapter;
import com.example.hexagonal.infrastructure.out.jpa.mapper.ICategoryEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.mapper.IObjectEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.mapper.IRestaurantEntityMapper;
import com.example.hexagonal.infrastructure.out.jpa.repository.ICategoryRepository;
import com.example.hexagonal.infrastructure.out.jpa.repository.IObjectRepository;
import com.example.hexagonal.infrastructure.out.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IObjectRepository objectRepository;
    private final IObjectEntityMapper objectEntityMapper;

    /*****  Category */
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    /*******  Restaurant *******/

    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;




    @Bean
    public IObjectPersistencePort objectPersistencePort() {
        return new ObjectJpaAdapter(objectRepository, objectEntityMapper);
    }

    @Bean
    public IObjectServicePort objectServicePort() {
        return new ObjectUseCase(objectPersistencePort());
    }

    /**************** CATEGORY ****/
    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort());
    }

    /**************** RESTAURANT ****/
    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantJpaAdapter(restaurantRepository, restaurantEntityMapper);
    }

    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort());
    }


}