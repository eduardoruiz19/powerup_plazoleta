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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/* Tratar en lo posible de NO usar LOMBOK aqui */
@Getter
@Setter
//@AllArgsConstructor
public class RestaurantModel {
    private Long idRestaurant;
    private String name;
    private String nit;
    private String address;
    private String phone;
    private Long id_owner;
    private String urlLogo;

    private List<OrderModel> orderModelList;

    private List<PlateModel> plateModelList;

    private List<RestaurantEmployeeModel> restaurantEmployeeModelList;

    public RestaurantModel() {
    }

    public RestaurantModel(Long idRestaurant, String name, String nit, String address, String phone, Long id_owner, String urlLogo, List<OrderModel> orderModelList, List<PlateModel> plateModelList, List<RestaurantEmployeeModel> restaurantEmployeeModelList) {
        if(name.isEmpty()){
            throw  new DomainException("Name can not be in blank");
        }
        if(nit.isEmpty()){
            throw  new DomainException("Nit can not be in blank");
        }
        if(address.isEmpty()){
            throw  new DomainException("Adress can not be in blank");
        }
        if(phone.isEmpty()){
            throw  new DomainException("Phone can not be in blank");
        }
        if(!validatePhone(phone)){
            throw new DomainException("Phone format is not Valid");
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
        if(validateNumber(name)){
            throw  new DomainException("Restaurant Cannot Be Only Numbers");
        }

        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {

        if(!validateNumber(nit)){
            throw  new DomainException("Nit must be Only Number");
        }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone.isEmpty()){
            throw new DomainException("Phone can not be in blank");
        }
        if(!validatePhone(phone)){
            throw  new DomainException("Phone format is not Valid");
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


    public boolean validatePhone(String phone){
        if(phone.length()>13){
            return false;
        }
        //String regex = "^\d{10}$";

        String regex = "[+][0-9]{12}";  //validate with CountryCode
        if(phone.length()<13){
            //regex= "[0-9]{10}";  //Validate without CountryCode
            regex= "[0-9]*";  //Validate without CountryCode

        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        return matcher.matches(); // returns true if pattern matches, else returns false

    }

    public boolean validateNumber(String number){
           String regex= "[0-9]*";  //Validate without CountryCode


        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);

        return matcher.matches(); // returns true if pattern matches, else returns false

    }

}
