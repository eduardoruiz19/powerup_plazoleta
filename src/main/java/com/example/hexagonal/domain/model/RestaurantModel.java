package com.example.hexagonal.domain.model;

import com.example.hexagonal.infrastructure.out.jpa.entity.OrderEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.PlateEntity;
import com.example.hexagonal.infrastructure.out.jpa.entity.RestaurantEmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.hexagonal.domain.exception.DomainException;
import javax.persistence.OneToMany;
import java.util.List;


/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
//@AllArgsConstructor
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

    public RestaurantModel() {
    }

    public RestaurantModel(Long idRestaurant, String name, Long nit, String address, Long phone, Long id_owner, String urlLogo, List<OrderModel> orderModelList, List<PlateModel> plateModelList, List<RestaurantEmployeeModel> restaurantEmployeeModelList) {
        if(name.isEmpty()){
            throw  new DomainException("Name can not be in blank");
        }
        if(nit.toString().isEmpty()){
            throw  new DomainException("Nit can not be in blank");
        }
        if(address.isEmpty()){
            throw  new DomainException("Adress can not be in blank");
        }
        if(phone.toString().isEmpty()){
            throw  new DomainException("Phone can not be in blank");
        }
        if(id_owner.toString().isEmpty()){
            throw  new DomainException("Id Owner can not be in blank");
        }
        if(urlLogo.isEmpty()){
            throw  new DomainException("Adress can not be in blank");
        }

        this.idRestaurant = idRestaurant;
        this.name = name;
        this.nit = nit;
        this.address = address;
        this.phone = phone;
        this.id_owner = id_owner;
        this.urlLogo = urlLogo;
        this.orderModelList = orderModelList;
        this.plateModelList = plateModelList;
        this.restaurantEmployeeModelList = restaurantEmployeeModelList;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty()){
            throw new DomainException("Name can not be in blank");
        }

        this.name = name;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address.isEmpty()){
            throw new DomainException("Adress can not be in blank");
        }

        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        if(phone.toString().isEmpty()){
            throw new DomainException("Phone can not be in blank");
        }

        this.phone = phone;
    }

    public Long getId_owner() {
        return id_owner;
    }

    public void setId_owner(Long id_owner) {
        this.id_owner = id_owner;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        if(urlLogo.isEmpty()){
            throw new DomainException("urlLogo can not be in blank");
        }

        this.urlLogo = urlLogo;
    }

    public List<OrderModel> getOrderModelList() {
        return orderModelList;
    }

    public void setOrderModelList(List<OrderModel> orderModelList) {
        this.orderModelList = orderModelList;
    }

    public List<PlateModel> getPlateModelList() {
        return plateModelList;
    }

    public void setPlateModelList(List<PlateModel> plateModelList) {
        this.plateModelList = plateModelList;
    }

    public List<RestaurantEmployeeModel> getRestaurantEmployeeModelList() {
        return restaurantEmployeeModelList;
    }

    public void setRestaurantEmployeeModelList(List<RestaurantEmployeeModel> restaurantEmployeeModelList) {
        this.restaurantEmployeeModelList = restaurantEmployeeModelList;
    }
}
