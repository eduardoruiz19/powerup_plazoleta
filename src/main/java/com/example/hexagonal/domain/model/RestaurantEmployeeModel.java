package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.OrderEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantEmployeeModel {
    private Long idRestaurantEmployee;

    private RestaurantModel restaurantModel;


    private List<OrderModel> orderModelList;

}
