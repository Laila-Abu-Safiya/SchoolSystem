package com.example.school.controller;

import com.example.school.entity.Subject;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "school/student/{studentId}/subject")
    public Set<Subject> getStudentSubject(@PathVariable("studentId") int studentId) throws Exception {
        return studentService.listStudentSubjects(studentId);
    }
}
