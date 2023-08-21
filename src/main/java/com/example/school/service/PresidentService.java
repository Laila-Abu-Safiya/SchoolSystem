package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.entity.Teacher;
import com.example.school.repository.PresidentRepository;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PresidentService {

    @Autowired
    private PresidentRepository presidentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    public Set<Teacher> listAllTeachers(int presidentId){
        return presidentRepository.findById(presidentId).get().getTeacherSet();
    }
    public Optional<Teacher> getSpecificTeacherInfo(int presidentId, int teacherId) throws Exception {
        Set<Teacher> teacherSet = presidentRepository.findById(presidentId).get().getTeacherSet();
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        boolean flag = false;
        for (Teacher teach : teacherSet) {
            if (teach == teacher.get()) {
                flag =true;
            }
        }
        if(flag) {
            return teacher;
        } else {
            throw new Exception("The president is not responsible of this teacher");
        }

    }

    public Set<Student> listAllStudents(int presidentId){
        return presidentRepository.findById(presidentId).get().getStudentSet();
    }

    public Optional<Student> getSpecificStudent(int presidentId, int studentId) throws Exception {
        Set<Student> studentSet = presidentRepository.findById(presidentId).get().getStudentSet();
        Optional<Student> student = studentRepository.findById(studentId);
        boolean flag = false;
        for (Student std : studentSet) {
            if (std == student.get()) {
                flag =true;
            }
        }
        if(flag) {
            return student;
        } else {
            throw new Exception("The president is not responsible of this student");
        }

    }
    public List<Subject> listAllSubject(int presidentId) {
        return List.of(presidentRepository.findAllSubject(presidentId));
    }

}
