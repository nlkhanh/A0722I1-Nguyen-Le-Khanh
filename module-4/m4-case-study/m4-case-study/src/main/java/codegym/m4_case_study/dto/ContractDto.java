package codegym.m4_case_study.dto;

import codegym.m4_case_study.model.Contract;
import codegym.m4_case_study.model.Customer;
import codegym.m4_case_study.model.Facility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private long id;
    private Facility facility;
    private Customer customer;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double deposit;
    private double totalMoney;

    public Contract dtoToEntity() {
        return new Contract(startDate, endDate, deposit, customer, facility);
    }
}
