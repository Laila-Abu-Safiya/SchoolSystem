package com.example.school.controller;

import com.example.school.entity.Subject;
import com.example.school.entity.Teacher;
import com.example.school.exptions.ValidateForPresident;
import com.example.school.service.PresidentService;
import com.example.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private final SubjectService subjectService;
    @Autowired
    private final PresidentService presidentService;

    public SubjectController(SubjectService subjectService, PresidentService presidentService) {
        this.subjectService = subjectService;
        this.presidentService = presidentService;
    }

    @GetMapping(path = "school/class/subject")
    public List<Subject> getAllSubject(){
        return subjectService.listAllSubject();
    }



    public void checkIfPresidentExists(boolean exists) throws ValidateForPresident {
        if(!exists){
            throw new ValidateForPresident("President is not exists");
        }
    }
}
