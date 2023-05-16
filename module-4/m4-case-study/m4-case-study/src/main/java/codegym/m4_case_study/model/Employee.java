package codegym.m4_case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "id_card", length = 45)
    @Pattern(regexp = "([0-9]{9})|([0-9]{12})")
    private String idCard;

    @Column(name = "phone_number", length = 45)
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}")
    private String phoneNumber;

    @Column(name = "email", length = 45)
    @Email
    private String email;

    @Column(name = "address", length = 45)
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonBackReference
    private Set<Contract> contracts = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;
}