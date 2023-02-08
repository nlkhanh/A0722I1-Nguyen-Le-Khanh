package com.product_manager.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String detail;
    private String manufacturer;

    public Product() {
    }

    public Product(int id, String name, double price, String detail, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
