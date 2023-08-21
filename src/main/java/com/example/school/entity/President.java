package com.example.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class President {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRESIDENT_ID")
    private int presidentId;
    @Column(name = "PRESIDENT_NAME")
    private String presidentName;
    @Column(name = "SCHOOL_NAME")
    private String schoolName;

    @OneToMany(mappedBy="president")
    @JsonIgnore
    private Set<Teacher> teacherSet;

    @OneToMany(mappedBy="studentPresident")
    @JsonIgnore
    private Set<Student> studentSet;
}
