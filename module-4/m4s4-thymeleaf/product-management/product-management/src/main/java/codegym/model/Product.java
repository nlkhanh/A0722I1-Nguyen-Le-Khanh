package codegym.model;

public class Product {
    private int id;
    private String name;
    private double cost;
    private String description;
    private String manufacture;

    public Product() {
    }

    public Product(int id, String name, double cost, String description, String manufacture) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.manufacture = manufacture;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
