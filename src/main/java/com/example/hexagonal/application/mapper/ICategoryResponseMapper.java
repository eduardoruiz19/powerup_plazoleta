package com.example.hexagonal.application.mapper;

import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.application.dto.response.ObjectResponseDto;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.ObjectModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryResponseMapper {
    CategoryResponseDto toResponse(CategoryModel categoryModel);

    List<CategoryResponseDto> toResponseList(List<CategoryModel> categoryModelList);
}
