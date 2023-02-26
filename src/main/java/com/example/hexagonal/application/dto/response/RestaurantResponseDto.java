package com.example.hexagonal.application.dto.response;

import com.example.hexagonal.infrastructure.out.jpa.entity.OrderEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEmployeeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class RestaurantResponseDto {
    private Long idRestaurant;
    private String name;
    private Long nit;
    private String address;
    private Long phone;
    private Long id_owner;

    private String urlLogo;


}
