package com.example.school.repository;

import com.example.school.entity.Subject;
import com.example.school.entity.Teacher;
import com.example.school.service.SubjectService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("SELECT teacher.subject from Teacher teacher where teacher.teacherId =?1")
    Subject [] findTeacherSubject(int teacherId);
}
