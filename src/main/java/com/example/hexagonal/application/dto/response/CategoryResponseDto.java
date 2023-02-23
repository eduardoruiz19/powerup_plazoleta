package com.example.hexagonal.application.dto.response;

import com.example.hexagonal.domain.model.PlateModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDto {
    private Long idCategory;


    private String name;

    private String description;

    private PlateModel plateModel;
}
