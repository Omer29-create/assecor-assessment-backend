package com.versuch.aufgabe.entity;

import com.versuch.aufgabe.util.Color;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "city")
    private String city;
    @Column(name = "color")
    private String color;

    public void setColor(String strColorCode) {
        String color = null;
        if (strColorCode != null){
            color = Color.getColor(strColorCode);
        }
        this.color = color;
    }
}

