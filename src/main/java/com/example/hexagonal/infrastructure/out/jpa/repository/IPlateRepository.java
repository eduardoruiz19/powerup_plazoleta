package com.example.hexagonal.infrastructure.out.jpa.repository;

import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/*   */

public interface IPlateRepository extends JpaRepository<PlateEntity, Long> {
//public interface IPlateRepository extends PagingAndSortingRepository<PlateEntity, Long> {
    PlateEntity findByIdPlate(long id);


}