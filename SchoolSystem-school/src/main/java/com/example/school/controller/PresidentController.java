package com.example.school.controller;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.entity.Teacher;
import com.example.school.exptions.ValidateForPresident;
import com.example.school.service.PresidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class PresidentController {

    @Autowired
    private final PresidentService presidentService;

    public PresidentController(PresidentService presidentService) {
        this.presidentService = presidentService;
    }

    @GetMapping(path = "school/president/{presidentId}/teachers")
    public Set<Teacher> getSchoolTeachers(@PathVariable("presidentId") int presidentId) throws ValidateForPresident {
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        checkIfPresidentExists(exists);
        return presidentService.listAllTeachers(presidentId);
    }

    @GetMapping(path = "school/president/{presidentId}/teachers/{teacherId}")
    public Optional<Teacher> getSpecificTeacher(@PathVariable("presidentId") int presidentId, @PathVariable("teacherId") int teacherId) throws Exception {
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        checkIfPresidentExists(exists);
        return presidentService.getSpecificTeacherInfo(presidentId,teacherId);
    }

    @GetMapping(path = "school/president/{presidentId}/students")
    public Set<Student> getSchoolStudents(@PathVariable("presidentId") int presidentId) throws ValidateForPresident {
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        checkIfPresidentExists(exists);
        return presidentService.listAllStudents(presidentId);
    }

    @GetMapping(path = "school/president/{presidentId}/students/{studentId}")
    public Optional<Student> getSpecificStudent(@PathVariable("presidentId") int presidentId, @PathVariable("studentId") int studentId) throws Exception {
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        checkIfPresidentExists(exists);
        return presidentService.getSpecificStudent(presidentId,studentId);
    }

    @GetMapping(path = "school/president/{presidentId}/courses")
    public List<Subject> getAllCourses(@PathVariable("presidentId") int presidentId) throws Exception {
        boolean exists = presidentService.checkIfPresidentExists(presidentId);
        checkIfPresidentExists(exists);
        return presidentService.listAllSubject(presidentId);
    }

    public void checkIfPresidentExists(boolean exists) throws ValidateForPresident {
        if(!exists){
            throw new ValidateForPresident("President is not exists");
        }
    }

}
