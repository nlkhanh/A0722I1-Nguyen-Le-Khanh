package models.facility;

public class Room extends Facility {
    private String freeServices;

    public Room() {
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String name, double area, double cost, int maxNumOfPeople, String rentType, String servicesType, String code, String freeServices) {
        super(name, area, cost, maxNumOfPeople, rentType, servicesType, code);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String getInfo() {
        return String.format("%s, %s, %s, %s, %s, %s, %s, %s", getName(), getServiceArea(),
                getCost(), getMaxNumOfPeople(), getRentType(), getServicesType(), getCode(), getFreeServices());
    }

    @Override
    public String toString() {
        return "Room{" +
                "code='" + super.getCode() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", area=" + super.getServiceArea() +
                ", cost=" + super.getCost() +
                ", maxNumOfPeople=" + super.getMaxNumOfPeople() +
                ", rentType=" + super.getRentType() +
                ", servicesType=" + super.getServicesType() +
                ", freeServices=" + freeServices +
                '}';
    }
}
