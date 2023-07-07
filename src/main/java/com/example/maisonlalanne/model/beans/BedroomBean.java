package com.example.maisonlalanne.model.beans;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bedroom")
public class BedroomBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int price;
    private String name, description, service;

    @OneToMany(mappedBy = "bedroom", fetch = FetchType.LAZY)
    private List<ReservationBean> bedroomreservation;
    public BedroomBean() {
    }

    public BedroomBean(long id) {
        this.id = id;
    }

    public BedroomBean(long id, String name, String description, String service) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.service = service;
    }

    public BedroomBean(long id, int price, String name, String service, String description) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.service = service;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
