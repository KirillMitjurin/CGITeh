package com.example.demo;

import jakarta.persistence.*;

// Loob andmebaasis tabel istekohadega.
@Entity
@Table(name="istekohad")
public class Istekohad {

// igal kohal on
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //rida
    @Column(name="row_number", nullable = false)
    private int rowNumber;
    // koht või veerg
    @Column(name="column_number", nullable = false)
    private int columnNumber;

    // kas koht on hõivatud
    @Column(name="seat_occupied", nullable = false)
    private boolean seatOccupied;


    //  kas istekoht on akna all
    @Column(name="under_window", nullable = false)
    private boolean underWindow;


    // kas istekohal on rohkem jalaruumi
    @Column(name="leg_space", nullable = false)
    private boolean legSpace;


    // kas see istekoht on lähedal väljapääsule
    @Column(name="close_to_exit", nullable = false)
    private boolean closeToExit;
    @ManyToOne
    @JoinColumn(name = "lennud_id", nullable = false)
    private Lennud lennud;

    public Istekohad() {
    }

    // konstruktor

    public Istekohad(int rowNumber, int columnNumber, boolean seatOccupied, boolean underWindow, boolean legSpace, boolean closeToExit, Lennud lennud) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.seatOccupied = seatOccupied;
        this.underWindow = underWindow;
        this.legSpace = legSpace;
        this.closeToExit = closeToExit;
        this.lennud = lennud;
    }


    // getters ja setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }


    public boolean isSeatOccupied() {
        return seatOccupied;
    }

    public void setSeatOccupied(boolean seatOccupied) {
        this.seatOccupied = seatOccupied;
    }

    public boolean isUnderWindow() {
        return underWindow;
    }

    public void setUnderWindow(boolean underWindow) {
        this.underWindow = underWindow;
    }

    public boolean isLegSpace() {
        return legSpace;
    }

    public void setLegSpace(boolean legSpace) {
        this.legSpace = legSpace;
    }

    public boolean isCloseToExit() {
        return closeToExit;
    }

    public void setCloseToExit(boolean closeToExit) {
        this.closeToExit = closeToExit;
    }

    public Lennud getLennud() {
        return lennud;
    }

    public void setLennud(Lennud lennud) {
        this.lennud = lennud;
    }
}
