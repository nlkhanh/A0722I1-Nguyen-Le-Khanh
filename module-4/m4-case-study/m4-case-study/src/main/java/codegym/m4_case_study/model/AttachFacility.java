package codegym.m4_case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "attach_facility")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "unit", length = 10)
    private String unit;

    @Column(name = "status", length = 45)
    private String status;

    @OneToMany(mappedBy = "attachFacility", orphanRemoval = true)
    @JsonBackReference
    private Set<ContractDetail> contractDetails = new LinkedHashSet<>();

}