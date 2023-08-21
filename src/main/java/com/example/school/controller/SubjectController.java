package com.example.school.controller;

import com.example.school.entity.Subject;
import com.example.school.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {
    @Autowired
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "school/class/subject")
    public List<Subject> getAllSubject(){
        return subjectService.listAllSubject();
    }
}
