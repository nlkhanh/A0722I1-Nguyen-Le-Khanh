package furama_resort.model.service_model;

public class Room extends Service {
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(int serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String freeService) {
        super(serviceId, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.freeService = freeService;
    }

    public Room(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, int rentTypeId, int serviceTypeId, String freeService) {
        super(serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId, serviceTypeId);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
