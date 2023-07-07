package com.example.maisonlalanne.model.beans;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class UserBean {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer point;
    private String name, firstname, email, password, phonenumber, idsession;
    private boolean isadmin;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ReservationBean> userreservation;



    public UserBean() {
    }
    public UserBean(long id) {
        this.id = id;
    }

    public UserBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserBean(long id, String name, String firstname, String email, String password) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }

    public UserBean(List<ReservationBean> userreservation) {
        this.userreservation = userreservation;
    }

    public UserBean(String idSession) {
        this.idsession = idSession;
    }

    public UserBean(String name, String firstname, String email) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
    }

    public UserBean(String name, List<ReservationBean> userreservation) {
        this.name = name;
        this.userreservation = userreservation;
    }

    public UserBean(String name, String firstname, String email, String password, String phonenumber ) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.phonenumber = phonenumber;
    }

    public UserBean(String name, String firstname, String email, String password) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
    }

    public UserBean(long id, String email, String password, String idsession) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.idsession = idsession;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public String getIdsession() {
        return idsession;
    }

    public void setIdsession(String idsession) {
        this.idsession = idsession;
    }
}



