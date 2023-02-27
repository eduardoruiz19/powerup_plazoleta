package com.example.hexagonal.infrastructure.out.jpa.mapper;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IPlateEntityMapper {

    PlateEntity toEntity(PlateModel plateModel);
    PlateModel toPlateModel(PlateEntity plateEntity);
    List<PlateModel> toPlateModelList(List<PlateEntity> plateEntityList);
}