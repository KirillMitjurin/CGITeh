package com.example.demo;


import jakarta.persistence.*;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    @Column(name="kuupaev", nullable = false)
    private LocalDate kuupaev;

    @Column(name="aeg", nullable = false)
    private LocalTime aeg;
    @Column(name="lennufirma", nullable = false)
    private String lennufirma;

    @Column(name= "lennuNumber", nullable = false)
    private String lennunumber;
    @Column(name="kestus", nullable = false)
    private Duration kestus;
    public Lennud() {

    }
    public Lennud(String lahteKoht, String sihtkoht, float hind, LocalDate kuupaev, LocalTime aeg, String lennufirma, String lennunumber, Duration kestus) {
        this.lahteKoht = lahteKoht;
        this.sihtKoht = sihtkoht;
        this.hind = hind;
        this.kuupaev = LocalDate.from(kuupaev);
        this.aeg = aeg;
        this.lennufirma = lennufirma;
        this.lennunumber = lennunumber;
        this.kestus = kestus;
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

    public Duration getKestus() {
        return kestus;
    }

    public LocalDate getKuupaev() {
        return kuupaev;
    }

    public void setKuupaevAeg(LocalDate kuupaevAeg) {
        this.kuupaev = kuupaevAeg;
    }

    public LocalTime getAeg() {
        return aeg;
    }

    public void setAeg(LocalTime aeg) {
        this.aeg = aeg;
    }

    public String getLennufirma() {
        return lennufirma;
    }

    public void setLennufirma(String lennufirma) {
        this.lennufirma = lennufirma;
    }

    public String getLennunumber() {
        return lennunumber;
    }

    public void setLennunumber(String lennunumber) {
        this.lennunumber = lennunumber;
    }


    public void setKestus(Duration kestus) {
        this.kestus = kestus;
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

}
