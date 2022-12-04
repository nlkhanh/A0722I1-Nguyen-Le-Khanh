package services.contract;

import models.booking.Contract;
import services.Service;

public interface ContractService extends Service<Contract> {
    String getContractNumber();
    double getMoney(String moneyType);
}
