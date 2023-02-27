package com.example.hexagonal.application.dto.request;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import lombok.Getter;
import lombok.Setter;

/* COMUNICACIONES O RESPUESTAS CON EL EXTERIOR PARA NO EXPONER LOS OBJECTMODEL */
@Getter
@Setter
public class CategoryRequestDto {
    private Long idCategory;


    private String name;

    private String description;

    private PlateModel plateModel;



}
