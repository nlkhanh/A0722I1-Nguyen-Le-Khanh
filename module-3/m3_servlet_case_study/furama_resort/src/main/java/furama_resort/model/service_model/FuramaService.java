package furama_resort.model.service_model;

public abstract class FuramaService {
    protected String serviceName;
    protected double serviceCode;
    protected int serviceMaxPeople;
    protected int rentTypeId;

    public FuramaService() {
    }

    public FuramaService(String serviceName, double serviceCode, int serviceMaxPeople, int rentTypeId) {
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(double serviceCode) {
        this.serviceCode = serviceCode;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }
}
