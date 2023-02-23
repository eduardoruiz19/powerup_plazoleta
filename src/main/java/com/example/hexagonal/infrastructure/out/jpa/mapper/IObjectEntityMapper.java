package com.example.hexagonal.infrastructure.out.jpa.mapper;

import com.example.hexagonal.domain.model.ObjectModel;
import com.example.hexagonal.infrastructure.out.jpa.entity.ObjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface IObjectEntityMapper {

    ObjectEntity toEntity(ObjectModel objectModel);
    ObjectModel toObjectModel(ObjectEntity objectEntity);
    List<ObjectModel> toObjectModelList(List<ObjectEntity> userEntityList);
}