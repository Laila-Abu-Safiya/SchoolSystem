package com.example.school.controller;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.exptions.ValidateForPresident;
import com.example.school.service.PresidentService;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class StudentController {
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final PresidentService presidentService;

    public StudentController(StudentService studentService, PresidentService presidentService) {
        this.studentService = studentService;
        this.presidentService = presidentService;
    }

    @GetMapping(path = "school/student/{studentId}/subject")
    public Set<Subject> getStudentSubject(@PathVariable("studentId") int studentId) throws Exception {
        return studentService.listStudentSubjects(studentId);
    }
    @PostMapping(path = "school/president/{presidentId}/student/{studentId}")
    public Student addNewStudent(@RequestBody Student student, @PathVariable("presidentId") int presidentId) throws ValidateForPresident {
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        checkIfPresidentExists(exists);
        return studentService.addNewStudent(student); ///// also here will be a problem
    }
    public void checkIfPresidentExists(boolean exists) throws ValidateForPresident {
        if(!exists){
            throw new ValidateForPresident("President is not exists");
        }
    }
}
