package m2s16_io_binaryfile_serialization.review.product_management;

import java.io.Serializable;

public class Product implements Serializable{
    private String code;
    private String name;
    private String manufacturer;
    private double cost;

    public Product() {
    }

    public Product(String code, String name, String manufacturer, double cost) {
        this.code = code;
        this.name = name;
        this.manufacturer = manufacturer;
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", cost=" + cost +
                '}';
    }
}
