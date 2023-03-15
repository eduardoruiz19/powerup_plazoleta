package com.example.hexagonal.infrastructure.out.jpa.repository;

import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*   */
//public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
public interface ICategoryRepository extends PagingAndSortingRepository<CategoryEntity, Long> {
    CategoryEntity findByIdCategory(long id);
    List<CategoryEntity> findAll();
}