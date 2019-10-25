package com.company.MotoInvservice.util.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Moto {

    private int id;
    private BigDecimal price;
    private String vin;
    private String make;
    private String model;
    private String year;
    private String color;

    public Moto(int id, BigDecimal price, String vin, String make, String model, String year, String color) {
        this.id = id;
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public Moto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moto moto = (Moto) o;
        return id == moto.id &&
                Objects.equals(price, moto.price) &&
                Objects.equals(vin, moto.vin) &&
                Objects.equals(make, moto.make) &&
                Objects.equals(model, moto.model) &&
                Objects.equals(year, moto.year) &&
                Objects.equals(color, moto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, vin, make, model, year, color);
    }
}
