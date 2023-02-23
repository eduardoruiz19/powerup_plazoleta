package com.example.hexagonal.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_id", nullable = false)
    private Long idRestaurant;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="nit",nullable = false)
    private Long nit;
    @Column(name="address",nullable = false)
    private String address;
    @Column(name="phone",nullable = false)
    private Long phone;
    @Column(name="id_owner",nullable = false)
    private Long id_owner;

    @Column(name="url_logo",nullable = false)
    private String urlLogo;
    @OneToMany(mappedBy = "restaurantEntity")
    private List<OrderEntity> orderEntityList;
    @OneToMany(mappedBy = "restaurantEntity")
    private List<PlateEntity> plateEntityList;
    @OneToMany(mappedBy = "restaurantEntity")
    private List<RestaurantEmployeeEntity> restaurantEmployeeEntityList;

}
