package com.example.maisonlalanne.model.beans;


import jakarta.persistence.*;

@Entity
@Table(name = "pictures")
public class PictureBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_bedroom", referencedColumnName = "id")
    private BedroomBean bedroom;
    private String link;

    public PictureBean() {
    }

    public PictureBean(long id, BedroomBean bedroom, String link) {
        this.id = id;
        this.bedroom = bedroom;
        this.link = link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BedroomBean getBedroom() {
        return bedroom;
    }

    public void setBedroom(BedroomBean bedroom) {
        this.bedroom = bedroom;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
