package com.example.hexagonal.application.mapper;


import com.example.hexagonal.application.dto.request.ObjectRequestDto;
import com.example.hexagonal.domain.model.ObjectModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/* ReportingPolicy.IGNORE, es para ignorar advertencias */
/* componentModel = "spring",  LO CONVIENTE EN UN BEAN */
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IObjectRequestMapper {
    ObjectModel toObject(ObjectRequestDto objectRequestDto);
}
