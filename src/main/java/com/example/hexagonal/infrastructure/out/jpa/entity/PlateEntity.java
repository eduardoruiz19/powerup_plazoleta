package com.example.hexagonal.infrastructure.out.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "plate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlateEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "plate_id", nullable = false)
    private Long idPlate;

    @Column(name="name")
    private String name;


    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name="restaurant_id")
    private RestaurantEntity restaurantEntity;


    @Column(name = "url_image", nullable = false)
    private String urlImage;

    @Column(name = "active", nullable = false)
    private boolean active;


    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    @JsonIgnore
    //@NotNull
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "plateEntity")
    @JsonIgnore
    private List<OrderPlateEntity> orderPlateEntityList;

}
