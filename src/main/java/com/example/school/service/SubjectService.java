package com.example.school.service;

import com.example.school.entity.Subject;
import com.example.school.repository.SubjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> listAllSubject() {
        return subjectRepository.findAll();
    }

}
