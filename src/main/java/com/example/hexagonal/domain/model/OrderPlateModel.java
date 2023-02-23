package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.OrderEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlateModel {
    private Long idOrderPlate;

    private OrderModel orderModel;

    private PlateModel  plateModel;


    private Date quantity;

}
