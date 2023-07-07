package com.example.maisonlalanne.model.beans;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "reservationsimple")
public class ReservationSimpleBean {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name, lastname, email, phonenumber;
    private int addressnumber;
    private String address;
    private int postalcode;
    private String city, bedroom;
    private Date datein, dateout;



    //ajout du onetomany car probleme sql avec address
//    @OneToMany(mappedBy = "reservationsimple" , fetch = FetchType.LAZY)
//    private List<ReservationSimpleBean> reservationsimplelist;

    public ReservationSimpleBean() {

    }

    public ReservationSimpleBean(long id) {
        this.id = id;
    }

    public ReservationSimpleBean(long id, String name, String lastname, String email, String phonenumber, int addressnumber, String address, int postalcode, String city, String bedroom, Date datein, Date dateout) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.addressnumber = addressnumber;
        this.address = address;
        this.postalcode = postalcode;
        this.city = city;
        this.bedroom = bedroom;
        this.datein = datein;
        this.dateout = dateout;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public Date getDatein() {
        return datein;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    public Date getDateout() {
        return dateout;
    }

    public void setDateout(Date dateout) {
        this.dateout = dateout;
    }

    public int getAddressnumber() {
        return addressnumber;
    }

    public void setAddressnumber(int addressnumber) {
        this.addressnumber = addressnumber;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }
}

