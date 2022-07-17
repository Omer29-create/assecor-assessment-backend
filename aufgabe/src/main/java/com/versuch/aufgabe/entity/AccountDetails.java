package com.versuch.aufgabe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_details")
public class AccountDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "color")
    private String color;

    public AccountDetails() {
        super();
    }

    /**
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param color
     */
    public AccountDetails(int id, String firstName, String lastName, String address, String color) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String strColorCode) {
        String color;
        int colorCode = Integer.parseInt(strColorCode);
        if (colorCode == 1) color = "blau";
        else if (colorCode == 2) color = "grün";
        else if (colorCode == 3) color = "violett";
        else if (colorCode == 4) color = "rot";
        else if (colorCode == 5) color = "gelb";
        else if (colorCode == 6) color = "türkis";
        else color = "weiß";
        this.color = color;
    }
}

