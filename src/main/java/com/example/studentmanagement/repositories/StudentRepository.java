package com.example.studentmanagement.repositories;

import com.example.studentmanagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findById(int id);
@Query("SELECT YEAR(s.dateNaissance),COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance)")
Collection<Object[]> findNbrStudentByYear();
}
