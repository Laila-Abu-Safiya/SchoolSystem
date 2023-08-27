package com.example.school.service;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.entity.Teacher;
import com.example.school.repository.PresidentRepository;
import com.example.school.repository.StudentRepository;
import com.example.school.repository.SubjectRepository;
import com.example.school.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    @Autowired
    private SubjectRepository subjectRepository;
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

    public boolean checkIfPresidentExists (int presidentId){
        boolean exists = presidentRepository.existsById(presidentId);
        if (exists) {
            return true;
        }
        return false;
    }

    @Transactional
    public Student editStudentInfo(Student student){
        Student std= studentRepository.findById(student.getStudentId()).orElseThrow(() -> new IllegalStateException(
                "student with id " + student.getStudentId() + " does not exists"
        ));
        if(!Objects.equals(student.getStudentName(),std.getStudentName())){
            std.setStudentName(student.getStudentName());
        }
        return std;
    }

    @Transactional
    public Teacher editTeacherInfo(Teacher teacher){
        Teacher teach= teacherRepository.findById(teacher.getTeacherId()).orElseThrow(() -> new IllegalStateException(
                "teacher with id " + teacher.getTeacherId() + " does not exists"
        ));
        if(!Objects.equals(teach.getTeacherName(),teacher.getTeacherName())){
            teach.setTeacherName(teacher.getTeacherName());
        }
        return teach;
    }

    public void deleteStudent(int presidentId, int studentId) throws Exception {
        Set<Student> studentSet = presidentRepository.findById(presidentId).get().getStudentSet();
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exists"
        ));
        boolean flag = false;
        for (Student std : studentSet){
            if(std == student){
                flag = true;
            }
        }
        if(flag) {
            studentRepository.deleteById(studentId);
        } else {
            throw new Exception("The president is not responsible of this student");
        }
    }
    public void deleteTeacher(int presidentId, int teacherId) throws Exception {
        Set<Teacher> teacherSet = presidentRepository.findById(presidentId).get().getTeacherSet();
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new IllegalStateException(
                "teacher with id " + teacherId + " does not exists"
        ));
        boolean flag = false;
        for (Teacher teach : teacherSet){
            if(teach == teacher){
                flag = true;
            }
        }
        if(flag) {
            teacherRepository.deleteById(teacherId);
        } else {
            throw new Exception("The president is not responsible of this teacher");
        }
    }
    public Student addNewStudent(Student student){
        return  studentRepository.save(student);
    }
    public Teacher addNewTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    @Transactional
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
     public Subject addNewSubject (Subject subject){
        return subjectRepository.save(subject);
     }
}