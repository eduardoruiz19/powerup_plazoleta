package com.example.hexagonal.domain.spi;

import com.example.hexagonal.domain.model.ObjectModel;

import java.util.List;


/*  PUERTO DE PERSISTENCIA */
public interface IObjectPersistencePort {
    ObjectModel saveObject(ObjectModel objectModel);

    List<ObjectModel> getAllObjects();
}