package codegym.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "s_class", length = 10)
    private String sClass;

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private Set<BorrowCard> borrowCards = new LinkedHashSet<>();

}