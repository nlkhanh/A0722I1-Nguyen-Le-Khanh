package models.facility;

public class Room extends Facility {
    String freeServices;

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String name, double area, double cost, int maxNumOfPeople, String rentType, String servicesType, String freeServices) {
        super(name, area, cost, maxNumOfPeople, rentType, servicesType);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + super.getName() + '\'' +
                ", area=" + super.getArea() +
                ", cost=" + super.getCost() +
                ", maxNumOfPeople=" + super.getMaxNumOfPeople() +
                ", rentType=" + super.getRentType() +
                ", servicesType=" + super.getServicesType() +
                ", freeServices=" + freeServices +
                '}';
    }
}
