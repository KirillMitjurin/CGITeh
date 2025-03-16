package com.example.demo;


import jakarta.persistence.*;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// Loob tabel lennud
@Entity
@Table(name = "lennud")
public class Lennud {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Koht, kust lennuk alustab
    @Column(name = "lahtekoht", nullable = false)
    private String lahteKoht;

    // Koht, kus lennuk lõpetab
    @Column(name = "sihtkoht", nullable = false)
    private String sihtKoht;

    // Piletihind
    @Column(name = "hind", nullable = false)
    private float hind;

    // Kuupäev, millal lend toimub
    @Column(name="kuupaev", nullable = false)
    private LocalDate kuupaev;

    // Kell, millal lennuk alustab lend
    @Column(name="väljasõit", nullable = false)
    private LocalTime väljasõit;

    // Kell, millal lennuk lõpetab lend
    @Column(name="saabumine", nullable = false)
    private LocalTime saabumine;

    @Column(name="lennufirma", nullable = false)
    private String lennufirma;

    @Column(name= "lennuNumber", nullable = false)
    private String lennunumber;

    // kui palju aega võtab reis.
    @Column(name="kestus", nullable = false)
    private Duration kestus;

    // Sideb kaks tabelid.
    @OneToMany(mappedBy = "lennud")
    private List<Istekohad> istekohad = new ArrayList<>();

    public Lennud() {

    }
    public Lennud(String lahteKoht, String sihtkoht, float hind, LocalDate kuupaev, LocalTime väljasõit,LocalTime saabumine,  String lennufirma, String lennunumber, Duration kestus) {
        this.lahteKoht = lahteKoht;
        this.sihtKoht = sihtkoht;
        this.hind = hind;
        this.kuupaev = LocalDate.from(kuupaev);
        this.väljasõit = väljasõit;
        this.saabumine = saabumine;
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

    public LocalTime getväljasõit() {
        return väljasõit;
    }

    public void setväljasõit(LocalTime aeg) {
        this.väljasõit = aeg;
    }

    public LocalTime getSaabumine() {
        return saabumine;
    }

    public void setSaabumine(LocalTime saabumine) {
        this.saabumine = saabumine;
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
