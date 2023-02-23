package com.example.hexagonal.infrastructure.out.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id", nullable = false)
    private  int orderId;

    @Column(name="client_id")
    private  Long clientId;

    @Column(name="date_order")
    @Temporal(TemporalType.DATE)
    private Date dateOrder;

    @Column(name="state")
    private String state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="chef_id")
    private  RestaurantEmployeeEntity chefId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="restaurant_id")
    private RestaurantEntity restaurantEntity;

    //@OneToMany
    //@JoinColumn(name="orders_id")  //AQUI VA EL NOMBRE DEL CAMPO EN LA TABLA
    @OneToMany(mappedBy="orderEntity")
    private List<OrderPlateEntity> orderPlateEntityList;

}
