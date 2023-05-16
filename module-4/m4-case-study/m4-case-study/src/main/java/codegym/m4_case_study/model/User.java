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
@Table(name = "user")
public class User {
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_username", referencedColumnName = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new LinkedHashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.MERGE)
    private Employee employee;
}