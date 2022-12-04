package repository.contract;

import models.booking.Contract;
import repository.Repository;

import java.util.LinkedHashSet;

public interface ContractRepository extends Repository<Contract, LinkedHashSet<Contract>> {
}
