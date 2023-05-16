package codegym.library.entity;

import codegym.library.entity.BorrowCard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "current_class", length = 45)
    private String currentClass;

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    @JsonBackReference
    private Set<BorrowCard> borrowCards = new LinkedHashSet<>();

}