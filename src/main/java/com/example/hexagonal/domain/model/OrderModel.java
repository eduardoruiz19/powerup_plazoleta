package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.OrderPlateEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEmployeeEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
    private  int orderId;


    private  Long clientId;

    private Date dateOrder;

    private String state;

    private RestaurantEmployeeModel chefId;

    private RestaurantModel restaurantEntity;

    private List<OrderPlateModel> orderPlateModelList;
}
