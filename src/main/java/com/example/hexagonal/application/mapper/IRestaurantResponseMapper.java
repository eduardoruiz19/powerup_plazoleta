package com.example.hexagonal.application.mapper;

import com.example.hexagonal.application.dto.response.ObjectResponseDto;
import com.example.hexagonal.application.dto.response.RestaurantResponseDto;
import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.domain.model.RestaurantModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponseMapper {
    RestaurantResponseDto toResponse(RestaurantModel restaurantModel);

    List<RestaurantResponseDto> toResponseList(List<RestaurantModel> RestaurantModelList);
}
