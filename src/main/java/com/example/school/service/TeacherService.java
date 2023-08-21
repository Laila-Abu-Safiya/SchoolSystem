package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.SubjectRepository;
import com.example.school.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;

    public Subject listTeacherSubjects(int teacherId) throws Exception {
        return teacherRepository.findById(teacherId).get().getSubject();
    }
    public Set<Student> listAllStudents(int teacherId){
        return teacherRepository.findById(teacherId).get().getSubject().getStudentSet();
    }
    public Optional<Student> getSpecificStudent(int teacherId, int studentId) throws Exception {
        Set<Student> studentSet = teacherRepository.findById(teacherId).get().getSubject().getStudentSet();
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
}
