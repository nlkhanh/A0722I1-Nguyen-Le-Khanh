package models.facility;

public class Villa extends Facility {
    private String roomType;
    private byte numberOfFloor;
    private double poolArea;

    public Villa() {
    }

    public Villa(String roomType, byte numberOfFloor, double poolArea) {
        this.roomType = roomType;
        this.numberOfFloor = numberOfFloor;
        this.poolArea = poolArea;
    }

    public Villa(String name, double area, double cost, int maxNumOfPeople, String rentType, String servicesType, String roomType, byte numberOfFloor, double poolArea) {
        super(name, area, cost, maxNumOfPeople, rentType, servicesType);
        this.roomType = roomType;
        this.numberOfFloor = numberOfFloor;
        this.poolArea = poolArea;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public byte getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(byte numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "name='" + super.getName() + '\'' +
                ", area=" + super.getArea() +
                ", cost=" + super.getCost() +
                ", maxNumOfPeople=" + super.getMaxNumOfPeople() +
                ", rentType=" + super.getRentType() +
                ", servicesType=" + super.getServicesType() +
                ", roomType=" + roomType +
                ", numberOfFloor=" + numberOfFloor +
                ", poolArea=" + poolArea +
                '}';
    }
}
