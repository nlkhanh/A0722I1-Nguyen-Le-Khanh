package furama_resort.model.service_model;

public class Villa extends Service {
    private String standardRoom;
    private String otherConvenience;
    private double poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String standardRoom, String otherConvenience, double poolArea, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String otherConvenience, double poolArea, int numberOfFloors) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String otherConvenience, double poolArea, int numberOfFloors) {
        super(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
