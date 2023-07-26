package com.example.maisonlalanne.model.beans;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class ReservationBean {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private Date datecreate, datein, dateout;
    private int nbday;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserBean user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_bedroom", referencedColumnName = "id")
    private BedroomBean bedroom;


    public ReservationBean() {

    }

    public ReservationBean(Date datecreate, Date datein, Date dateout, UserBean user, BedroomBean bedroom) {
        this.datecreate = datecreate;
        this.datein = datein;
        this.dateout = dateout;
        this.user = user;
        this.bedroom = bedroom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
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

    public int getNbday() {
        return nbday;
    }

    public void setNbday(int nbday) {
        this.nbday = nbday;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public BedroomBean getBedroom() {
        return bedroom;
    }

    public void setBedroom(BedroomBean bedroom) {
        this.bedroom = bedroom;
    }
}
