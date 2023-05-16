package codegym.m4_case_study.model;

import codegym.m4_case_study.dto.ContractDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "deposit")
    private Double deposit;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "facility_id")
    private Facility facility;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private Set<ContractDetail> contractDetails = new LinkedHashSet<>();

    public Contract(LocalDateTime startDate, LocalDateTime endDate, Double deposit, Customer customer, Facility facility) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.customer = customer;
        this.facility = facility;
    }

    public ContractDto entityToDto() {
        return new ContractDto(this.id, this.facility, this.customer, this.startDate, this.endDate, this.deposit, calTotalMoney());
    }


    private double calTotalMoney() {
        double price = 0;

        if (contractDetails.size() != 0) {
            for (ContractDetail contractDetail : contractDetails) {
                price += (contractDetail.getAttachFacility().getCost() * contractDetail.getQuantity());
            }
        }

//        long timeDiff;
//        if (facility.getRentType().getId() == 1) {
//            timeDiff = ChronoUnit.HOURS.between(this.startDate, this.endDate);
//        } else if (facility.getRentType().getId() == 2) {
//            timeDiff = ChronoUnit.DAYS.between(this.startDate, this.endDate);
//        } else if (facility.getRentType().getId() == 3) {
//            timeDiff = ChronoUnit.MONTHS.between(this.startDate, this.endDate);
//        } else {
//            timeDiff = ChronoUnit.YEARS.between(this.startDate, this.endDate);
//        }
//        if (timeDiff == 0) {
//            timeDiff = 1;
//        }
        return (facility.getCost() + price);
    }
}