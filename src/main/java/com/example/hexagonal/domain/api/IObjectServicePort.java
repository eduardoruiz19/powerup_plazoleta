package com.example.hexagonal.domain.api;

import com.example.hexagonal.domain.model.ObjectModel;

import java.util.List;


/* MÉTODOS QUE NOS INTERESA QUE EXPONGA NUESTRO DOMINIO  */
public interface IObjectServicePort {

    void saveObject(ObjectModel objectModel);

    List<ObjectModel> getAllObjects();
}