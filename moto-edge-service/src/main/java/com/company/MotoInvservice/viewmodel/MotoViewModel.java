package com.company.MotoInvservice.viewmodel;

import com.company.MotoInvservice.util.model.Moto;

import java.math.BigDecimal;
import java.util.Objects;

public class MotoViewModel {
    private int id;
    private BigDecimal price;
    private String vin;
    private String make;
    private String model;
    private String year;
    private String color;
    private BigDecimal totalCost;

    public MotoViewModel(int id, BigDecimal price, String vin, String make, String model, String year, String color, BigDecimal totalCost) {
        this.id = id;
        this.price = price;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.totalCost = totalCost;
    }

    public MotoViewModel() {
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

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MotoViewModel that = (MotoViewModel) o;
        return id == that.id &&
                Objects.equals(price, that.price) &&
                Objects.equals(vin, that.vin) &&
                Objects.equals(make, that.make) &&
                Objects.equals(model, that.model) &&
                Objects.equals(year, that.year) &&
                Objects.equals(color, that.color) &&
                Objects.equals(totalCost, that.totalCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, vin, make, model, year, color, totalCost);
    }
}
