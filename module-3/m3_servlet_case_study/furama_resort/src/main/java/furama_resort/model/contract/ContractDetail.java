package furama_resort.model.contract;

public class ContractDetail {
    private int id;
    private int contractId;
    private int attachServiceId;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, int contractId, int attachServiceId, int quantity) {
        this.id = id;
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public ContractDetail(int contractId, int attachServiceId, int quantity) {
        this.contractId = contractId;
        this.attachServiceId = attachServiceId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
