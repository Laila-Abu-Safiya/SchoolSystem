package com.example.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID")
    private int classId;
    @Column(name = "CLASS_NAME")
    private String className;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "presidentId")
    private President classPresident;

    @OneToMany(mappedBy = "students")
    private Set<Student> studentSet;
}
