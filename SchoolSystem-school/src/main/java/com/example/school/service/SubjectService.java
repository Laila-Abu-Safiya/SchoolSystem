package com.example.school.service;

import com.example.school.entity.Subject;
import com.example.school.repository.SubjectRepository;
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

    public Subject addNewSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Subject subject){
        Subject sub = subjectRepository.findById(subject.getSubjectId()).orElseThrow(() ->new IllegalStateException(
                "subject with id" + subject.getSubjectId() + "does not exists"
        ));
        sub.setSubjectName(subject.getSubjectName());
        System.out.println(sub.getSubjectName());
        return sub;
    }

    public void deleteSubject(int subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
