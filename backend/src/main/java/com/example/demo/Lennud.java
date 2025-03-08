package com.example.demo;


import jakarta.persistence.*;

@Entity
@Table(name = "lennud")
public class Lennud {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "lahtekoht", nullable = false)
    private String lahteKoht;

    @Column(name = "sihtkoht", nullable = false)
    private String sihtKoht;


    @Column(name = "hind", nullable = false)
    private float hind;
    public Lennud() {

    }

    public Lennud(String lahteKoht,String sihtkoht, float hind) {
        this.lahteKoht = lahteKoht;
        this.sihtKoht = sihtkoht;
        this.hind = hind;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSihtKoht(String sihtKoht) {
        this.sihtKoht = sihtKoht;
    }


    public String getSihtkoht() {
        return sihtKoht;
    }

    public String getLahteKoht() {
        return lahteKoht;
    }

    public void setLahteKoht(String lahteKoht) {
        this.lahteKoht = lahteKoht;
    }

    public float getHind() {
        return hind;
    }

    public void setHind(float hind) {
        this.hind = hind;
    }
    @Override
    public String toString() {
        return "Lennud{" +
                "id=" + id +
                ", sihtkoht='" + sihtKoht + '\'' +
                ", hind=" + hind +
                '}';
    }

}
