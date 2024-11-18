package com.example.studentmanagement.services;

import com.example.studentmanagement.entities.Student;
import com.example.studentmanagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRep;

    public Student save(Student student) {
        return studentRep.save(student);
    }
    public boolean delete(int id) {
        Optional<Student> studentOpt = Optional.ofNullable(studentRep.findById(id));
        if (studentOpt.isPresent()) {
            studentRep.delete(studentOpt.get());
            return true;
        } else {
            return false;
        }
    }
        public List<Student> findAll () {
            return studentRep.findAll();
        }
        public Long countStudent () {
            return studentRep.count();
        }
    public Collection<?> findNbrStudentByYear(){
    return studentRep.findNbrStudentByYear();
}
}
