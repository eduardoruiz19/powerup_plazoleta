package com.example.hexagonal.infrastructure.out.jpa.repository;

import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*   */
public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

}