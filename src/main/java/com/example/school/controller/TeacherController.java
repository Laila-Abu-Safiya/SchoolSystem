package com.example.school.controller;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RestController
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(path = "school/teacher/{teacherId}/subjects")
    public Subject getSpecificTeacher(@PathVariable("teacherId") int teacherId) throws Exception {
        return teacherService.listTeacherSubjects(teacherId);
    }
    @GetMapping(path = "school/teacher/{teacherId}/students")
    public Set<Student> getAllStudentList(@PathVariable("teacherId") int teacherId){
        return teacherService.listAllStudents(teacherId);
    }

    @GetMapping(path = "school/teacher/{teacherId}/students/{studentId}")
    public Optional<Student> getSpecificStudent(@PathVariable("teacherId") int teacherId, @PathVariable("studentId") int studentId) throws Exception {
        return teacherService.getSpecificStudent(teacherId,studentId);
    }
}
