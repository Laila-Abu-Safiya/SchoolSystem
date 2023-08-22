package com.example.school.repository;

import com.example.school.entity.President;
import com.example.school.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PresidentRepository extends JpaRepository<President, Integer> {

    @Query("SELECT subject from Subject subject where subject.teacher.president.presidentId = ?1")
    Subject [] findAllSubject(int presidentId);
}
