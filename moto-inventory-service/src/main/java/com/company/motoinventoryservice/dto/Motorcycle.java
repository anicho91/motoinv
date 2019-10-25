package com.company.motoinventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Motorcycle {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "vin")
    private String vin;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private String year;
    @Column(name = "color")
    private String color;


    public int getId() {
        return id;
    }

    public Motorcycle setId(int id) {
        this.id = id;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Motorcycle setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getVin() {
        return vin;
    }

    public Motorcycle setVin(String vin) {
        this.vin = vin;
        return this;
    }

    public String getMake() {
        return make;
    }

    public Motorcycle setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Motorcycle setModel(String model) {
        this.model = model;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Motorcycle setYear(String year) {
        this.year = year;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Motorcycle setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motorcycle that = (Motorcycle) o;
        return id == that.id &&
                Objects.equals(price, that.price) &&
                Objects.equals(vin, that.vin) &&
                Objects.equals(make, that.make) &&
                Objects.equals(model, that.model) &&
                Objects.equals(year, that.year) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, vin, make, model, year, color);
    }


    //    create table if not exists motorcycle (
//            id int not null auto_increment primary key,
//            price decimal(7,2) not null,
//    vin varchar(20) not null,
//    make varchar(20) not null,
//    model varchar(20) not null,
//    year varchar(4) not null,
//    color varchar(20) not null
//            );

}
