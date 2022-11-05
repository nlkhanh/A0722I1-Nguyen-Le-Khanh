package models.facility;

public class House extends Facility {
    String roomType;
    byte numberOfFloor;

    public House() {
    }

    public House(String roomType, byte numberOfFloor) {
        this.roomType = roomType;
        this.numberOfFloor = numberOfFloor;
    }

    public House(String name, double area, double cost, int maxNumOfPeople, String rentType, String servicesType, String roomType, byte numberOfFloor) {
        super(name, area, cost, maxNumOfPeople, rentType, servicesType);
        this.roomType = roomType;
        this.numberOfFloor = numberOfFloor;
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

    @Override
    public String toString() {
        return "House{" +
                "name='" + super.getName() + '\'' +
                ", area=" + super.getArea() +
                ", cost=" + super.getCost() +
                ", maxNumOfPeople=" + super.getMaxNumOfPeople() +
                ", rentType=" + super.getRentType() +
                ", servicesType=" + super.getServicesType() +
                ", roomType=" + roomType +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
