package com.example.school.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private int subjectId;
    @Column(name = "SUBJECT_Name")
    private String subjectName;
    @ManyToMany(mappedBy = "likedSubject")
    @JsonIgnore
    Set<Student> studentSet;

    @OneToOne(mappedBy = "subject")
    @JsonIgnore
    private Teacher teacher;
}
