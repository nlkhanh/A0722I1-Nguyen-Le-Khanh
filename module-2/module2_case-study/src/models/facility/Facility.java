package models.facility;

public abstract class Facility {
    private String name;
    private double serviceArea;
    private double cost;
    private int maxNumOfPeople;
    private String rentType;
    private String servicesType;
    private String code;

    public Facility() {
    }

    public Facility(String name, double serviceArea, double cost, int maxNumOfPeople, String rentType, String servicesType, String code) {
        this.name = name;
        this.serviceArea = serviceArea;
        this.cost = cost;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentType = rentType;
        this.servicesType = servicesType;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(double serviceArea) {
        this.serviceArea = serviceArea;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "Facility{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", service area=" + serviceArea +
                ", cost=" + cost +
                ", maxNumOfPeople=" + maxNumOfPeople +
                ", rentType=" + rentType +
                ", servicesType=" + servicesType +
                '}';
    }
}
