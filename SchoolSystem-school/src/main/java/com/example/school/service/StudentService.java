package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Set<Subject> listStudentSubjects(int studentId) throws Exception {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.equals("")){
            throw new Exception("The student is not exists");
        }
        return student.get().getLikedSubject();
    }

    public Student addNewStudent(Student student){
        return studentRepository.save(student);
    }

}
