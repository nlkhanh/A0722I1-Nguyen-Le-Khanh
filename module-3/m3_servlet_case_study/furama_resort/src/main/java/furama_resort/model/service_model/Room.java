package furama_resort.model.service_model;

public class Room extends FuramaService{
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, double serviceCode, int serviceMaxPeople, int rentTypeId, String freeService) {
        super(serviceName, serviceCode, serviceMaxPeople, rentTypeId);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
}
