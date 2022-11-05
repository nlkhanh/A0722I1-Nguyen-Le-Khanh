package models.facility;

public abstract class Facility {
    private String name;
    private double area;
    private double cost;
    private int maxNumOfPeople;
    private String rentType;
    private String servicesType;

    public Facility() {
    }

    public Facility(String name, double area, double cost, int maxNumOfPeople, String rentType, String servicesType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentType = rentType;
        this.servicesType = servicesType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxNumOfPeople() {
        return maxNumOfPeople;
    }

    public void setMaxNumOfPeople(int maxNumOfPeople) {
        this.maxNumOfPeople = maxNumOfPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getServicesType() {
        return servicesType;
    }

    public void setServicesType(String servicesType) {
        this.servicesType = servicesType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", cost=" + cost +
                ", maxNumOfPeople=" + maxNumOfPeople +
                ", rentType=" + rentType +
                ", servicesType=" + servicesType +
                '}';
    }
}
