package com.example.hexagonal.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "category_id", nullable = false)
    private Long idCategory;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="restaurant_id")
    private RestaurantEntity restaurantEntity;

    @Column(name = "url_image", nullable = false)
    private String urlImage;

    @Column(name = "active", nullable = false)
    private String active;
    @OneToMany(mappedBy = "plateEntity")
    private List<CategoryEntity> categoryEntityList;

    @OneToMany(mappedBy = "plateEntity")
    private List<OrderPlateEntity> orderPlateEntityList;

}
