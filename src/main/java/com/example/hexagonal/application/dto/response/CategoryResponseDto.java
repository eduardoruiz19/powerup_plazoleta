package com.example.hexagonal.application.dto.response;

import com.example.hexagonal.domain.model.PlateModel;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class CategoryResponseDto {
    private Long idCategory;


    private String name;

    private String description;


    private List<PlateModel> plateEntityList;

}
