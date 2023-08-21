package com.example.school.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID")
    private int studentId;
    @Column(name = "STUDENT_NAME")
    private String studentName;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "subject_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    Set<Subject> likedSubject;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="president_id", nullable=false)
    private President studentPresident;

}
