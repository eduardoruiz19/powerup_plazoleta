package com.example.hexagonal.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_plate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderPlateEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_plate_id", nullable = false)
    private Long idOrderPlate;

    @ManyToOne
    @JoinColumn(name="id_orders")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name="plate_id")
    private PlateEntity plateEntity;


    @Column(name = "quantity", nullable = false)
    private Date quantity;


}
