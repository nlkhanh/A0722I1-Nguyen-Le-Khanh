package models.facility;

public class Villa extends Facility {
    private String roomType;
    private int numOfFloor;
    private double poolArea;

    public Villa() {
    }

    public Villa(String roomType, int numberOfFloor, double poolArea) {
        this.roomType = roomType;
        this.numOfFloor = numberOfFloor;
        this.poolArea = poolArea;
    }

    public Villa(String name, double area, double cost, int maxNumOfPeople, String rentType, String servicesType, String code, String roomType, int numberOfFloor, double poolArea) {
        super(name, area, cost, maxNumOfPeople, rentType, servicesType, code);
        this.roomType = roomType;
        this.numOfFloor = numberOfFloor;
        this.poolArea = poolArea;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    @Override
    public String getInfo() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s", getName(), getServiceArea(),
                getCost(), getMaxNumOfPeople(), getRentType(), getServicesType(), getCode(), getRoomType(),
                getNumOfFloor(), getPoolArea());
    }

    @Override
    public String toString() {
        return "Villa{" +
                "code='" + super.getCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", area=" + super.getServiceArea() +
                ", cost=" + super.getCost() +
                ", maxNumOfPeople=" + super.getMaxNumOfPeople() +
                ", rentType=" + super.getRentType() +
                ", servicesType=" + super.getServicesType() +
                ", roomType=" + roomType +
                ", numberOfFloor=" + numOfFloor +
                ", poolArea=" + poolArea +
                '}';
    }
}
