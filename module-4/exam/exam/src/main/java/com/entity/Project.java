package com.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", length = 45)
    @NotBlank(message = "Cannot empty")
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "required_money")
    @Min(value = 30000000, message = "Min 30.000.000")
    private Double requiredMoney;

    @Column(name = "detail", length = 1000)
    @NotBlank(message = "Cannot empty")
    private String detail;

    @Column(name = "registry_month")
    @Range(min = 1, max = 12, message = "Min = 1 and Max = 12")
    private Integer registryMonth;

    @Column(name = "register_date")
    private LocalDate registerDate;

    @Column(name = "price")
    private Double price;

    public Double calPrice() {
        double pricePercent = 0.0;
        if ((requiredMoney < 100000000)) {
            pricePercent = 0.01;
        } else if (requiredMoney <= 500000000) {
            pricePercent = 0.02;
        } else if (requiredMoney > 500000000) {
            pricePercent = 0.03;
        }
        return pricePercent*requiredMoney*registryMonth;
    }
}