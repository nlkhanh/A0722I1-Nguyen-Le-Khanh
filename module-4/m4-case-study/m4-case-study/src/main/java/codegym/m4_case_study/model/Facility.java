package codegym.m4_case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "area")
    private Long area;

    @Column(name = "name", length = 45)
    @Pattern(regexp = "^([A-Z0-9][a-z0-9]*[ ]*)+$")
    private String name;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "max_people")
    private Integer maxPeople;

    @Column(name = "standard_room", length = 45)
    private String standardRoom;

    @Column(name = "description_other_convenience", length = 45)
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    private Double poolArea;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @Column(name = "facility_free")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "facility_type_id")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @OneToMany(mappedBy = "facility", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonBackReference
    private Set<Contract> contracts = new LinkedHashSet<>();

}