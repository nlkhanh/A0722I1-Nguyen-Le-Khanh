package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "business")
    private String business;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company", orphanRemoval = true)
    @JsonBackReference
    private Set<Project> projects = new LinkedHashSet<>();

}