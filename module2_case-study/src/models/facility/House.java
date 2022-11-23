package models.facility;

public class House extends Facility {
    private String roomType;
    private int numOfFloor;

    public House() {
    }

    public House(String roomType, int numOfFloor) {
        this.roomType = roomType;
        this.numOfFloor = numOfFloor;
    }

    public House(String name, double area, double cost, int maxNumOfPeople, String rentType, String servicesType, String code , String roomType, int numOfFloor) {
        super(name, area, cost, maxNumOfPeople, rentType, servicesType, code);
        this.roomType = roomType;
        this.numOfFloor = numOfFloor;
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

    @Override
    public String toString() {
        return "House{" +
                "code='" + super.getCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", area=" + super.getServiceArea() +
                ", cost=" + super.getCost() +
                ", maxNumOfPeople=" + super.getMaxNumOfPeople() +
                ", rentType=" + super.getRentType() +
                ", servicesType=" + super.getServicesType() +
                ", roomType=" + roomType +
                ", numOfFloor=" + numOfFloor +
                '}';
    }
}
