package com.example.demo;

public class Lennud {
    int id;

    String sihtkoht;

    float hind;

    public int getId() {
        return id;
    }


    public Lennud(int id, String sihtkoht, float hind) {
        this.id = id;
        this.sihtkoht = sihtkoht;
        this.hind = hind;
    }

    public String getSihtkoht() {
        return sihtkoht;
    }

    public float getHind() {
        return hind;
    }

    @Override
    public String toString() {
        return "Lennud{" +
                "id=" + id +
                ", sihtkoht='" + sihtkoht + '\'' +
                ", hind=" + hind +
                '}';
    }

}
