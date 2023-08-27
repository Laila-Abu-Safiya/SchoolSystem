package com.example.school.controller;

import com.example.school.entity.Student;
import com.example.school.exptions.ValidateForClass;
import com.example.school.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ClassController {
    @Autowired
    private final ClassService classService;
    public ClassController(ClassService classService) {
        this.classService = classService;
    }
    @GetMapping(path = "school/Class/{classId}/students")
    public Set<Student> getClassStudents(@PathVariable("classId") int classId) throws ValidateForClass {
        boolean exists = classService.checkIfClassExists(classId);
        checkIfClassExists(exists);
        return classService.listAllStudents
                (classId);
    }

    public void checkIfClassExists(boolean exists) throws ValidateForClass {
        if(!exists){
            throw new ValidateForClass("Class is not exists");
        }
    }
}
