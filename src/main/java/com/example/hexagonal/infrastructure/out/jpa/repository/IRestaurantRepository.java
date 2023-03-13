package com.example.hexagonal.infrastructure.out.jpa.repository;

import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import org.springframework.data.domain.Pageable;

/*   */
public interface IRestaurantRepository extends PagingAndSortingRepository<RestaurantEntity, Long> {

    RestaurantEntity findByIdRestaurant(long id);
    List<RestaurantEntity> findAll();


}