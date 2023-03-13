package com.example.hexagonal.application.mapper;


import com.example.hexagonal.application.dto.request.CategoryRequestDto;
import com.example.hexagonal.application.dto.request.PlateRequestDto;
import com.example.hexagonal.domain.model.CategoryModel;
import com.example.hexagonal.domain.model.PlateModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/* ReportingPolicy.IGNORE, es para ignorar advertencias */
/* componentModel = "spring",  LO CONVIENTE EN UN BEAN */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPlateRequestMapper {
    PlateModel toPlateModel(PlateRequestDto plateRequestDto);
    PlateRequestDto toPlateRequestDto(PlateModel plateModel);
}
