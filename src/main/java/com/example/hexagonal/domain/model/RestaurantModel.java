package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.OrderEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;


/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantModel {
    private Long idRestaurant;
    private String name;
    private Long nit;
    private String address;
    private Long phone;
    private Long id_owner;
    private String urlLogo;

    private List<OrderModel> orderModelList;

    private List<PlateModel> plateModelList;

    private List<RestaurantEmployeeModel> restaurantEmployeeModelList;

}
