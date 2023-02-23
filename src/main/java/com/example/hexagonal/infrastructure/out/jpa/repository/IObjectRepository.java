package com.example.hexagonal.infrastructure.out.jpa.repository;

import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*   */
public interface IObjectRepository extends JpaRepository<ObjectEntity, Long> {

}