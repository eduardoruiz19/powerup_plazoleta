package com.example.hexagonal.infrastructure.out.jpa.mapper;

import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.infrastructure.out.jpa.entity.CategoryEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface ICategoryEntityMapper {

    CategoryEntity toEntity(CategoryModel categoryModel);
    CategoryModel toCategoryModel(CategoryEntity categoryEntity);
    List<CategoryModel> toCategoryModelList(List<CategoryEntity> categoryEntityList);
}