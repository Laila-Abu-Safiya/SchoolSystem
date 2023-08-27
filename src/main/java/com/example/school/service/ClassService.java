package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public Set<Student> listAllStudents(int classId){
        return classRepository.findById(classId).get().getStudentSet();
    }
    public boolean checkIfClassExists (int classId){
        boolean exists = classRepository.existsById(classId);
        if (exists) {
            return true;
        }
        return false;
    }
}
