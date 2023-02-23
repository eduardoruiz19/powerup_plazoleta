package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
    private Long idCategory;


    private String name;

    private String description;

    private PlateModel plateModel;

}
