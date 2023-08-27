package com.example.school.controller;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.entity.Teacher;
import com.example.school.exptions.ValidateForPresident;
import com.example.school.service.PresidentService;
import com.example.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class TeacherController {
    @Autowired
    private final TeacherService teacherService;
    @Autowired
    private final PresidentService presidentService;

    public TeacherController(TeacherService teacherService, PresidentService presidentService) {
        this.teacherService = teacherService;
        this.presidentService = presidentService;
    }

    @GetMapping(path = "school/teacher/{teacherId}/subjects")
    public Subject getSpecificTeacher(@PathVariable("teacherId") int teacherId) throws Exception {
        return teacherService.listTeacherSubjects(teacherId);
    }
    @GetMapping(path = "school/teacher/{teacherId}/students")
    public Set<Student> getAllStudentList(@PathVariable("teacherId") int teacherId) {
        return teacherService.listAllStudents(teacherId);
    }
    @GetMapping(path = "school/teacher/{teacherId}/student/{studentId}")
    public Optional<Student> getSpecificStudent(@PathVariable("teacherId") int teacherId, @PathVariable("studentId") int studentId) throws Exception {
        return teacherService.getSpecificStudent(teacherId, studentId);
    }
    @GetMapping(path = "school/teacher/{teacherId}")
    public Optional<Teacher> getTeacherInfo(@PathVariable("teacherId") int teacherId){
        return teacherService.getTeacherInfo(teacherId);
    }
    @PutMapping(path = "school/teacher/{teacherId}/student/{studentId}")
    public Optional<Student> editStudentInfo(@PathVariable("teacherId") int teacherId, @PathVariable("studentId") int studentId, @RequestBody String name){
        return teacherService.editStudentIno(teacherId,studentId,name);
    }
}


