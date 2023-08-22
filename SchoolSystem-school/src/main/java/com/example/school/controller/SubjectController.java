package com.example.school.controller;

import com.example.school.entity.Subject;
import com.example.school.entity.Teacher;
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

    @PostMapping(path = "school/president/{presidentId}/subject")
    public Subject addNewTeacher(@RequestBody Subject subject, @PathVariable("presidentId") int presidentId) throws Exception {
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        return subjectService.addNewSubject(subject);

    }

    @PutMapping(path = "school/president/{presidentId}/subject/{subjectId}")
    public Subject updateSubjectInfo (@PathVariable("presidentId") int presidentId, @RequestBody Subject subject){
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        return subjectService.updateSubject(subject);
    }

    @DeleteMapping(path = "school/president/{presidentId}/subject/{subjectId}")
    public void deleteSubjectById (@PathVariable("presidentId") int presidentId, @PathVariable("subjectId") int subjectId) {
        subjectService.deleteSubject(subjectId);
    }
}
