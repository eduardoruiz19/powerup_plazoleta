package com.example.hexagonal.application.mapper;

import com.example.hexagonal.application.dto.response.CategoryResponseDto;
import com.example.hexagonal.application.dto.response.PlateResponseDto;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlateResponseMapper {
    PlateResponseDto toResponseDto(PlateModel plateModel);

    List<PlateResponseDto> toResponseList(List<PlateModel> plateModelList);
}
