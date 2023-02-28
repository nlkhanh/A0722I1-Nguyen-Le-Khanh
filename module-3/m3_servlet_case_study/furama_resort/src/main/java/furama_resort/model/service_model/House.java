package furama_resort.model.service_model;

public class House extends Service {
    private String standardRoom;
    private String otherConvenience;
    private int numberOfFloors;

    public House() {
    }

    public House(String standardRoom, String otherConvenience, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.numberOfFloors = numberOfFloors;
    }

    public House(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String otherConvenience, int numberOfFloors) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String otherConvenience, int numberOfFloors) {
        super(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.standardRoom = standardRoom;
        this.otherConvenience = otherConvenience;
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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
