package services.contract;

import models.booking.Contract;
import services.Service;

import java.util.Set;

public interface ContractService extends Service<Contract, Set<Contract>> {
    String getContractNumber();
    double getMoney(String moneyType);
}
