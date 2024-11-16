package com.example.studentmanagement.repositories;

import com.example.studentmanagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student finById(int id);
@Query("SELECTE YEAR(s.dateNaissance),COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance)")
    List<Student> findNbrStudentByYear();
}
