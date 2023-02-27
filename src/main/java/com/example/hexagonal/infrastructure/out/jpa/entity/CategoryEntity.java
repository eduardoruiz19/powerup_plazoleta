package com.example.hexagonal.infrastructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    private Long idCategory;

    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @OneToMany(fetch =FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "categoryEntity")
    private List<PlateEntity> plateEntityList;

}
