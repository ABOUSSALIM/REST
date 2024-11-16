package com.example.studentmanagement.controllers;

import com.example.studentmanagement.entities.Student;
import com.example.studentmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    private StudentService studentServ ;
    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        Student saveStudent = studentServ.save(student);
        return new ResponseEntity<>(saveStudent ,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        boolean deleted = studentServ.delete(id);
        if(deleted){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = studentServ.findAll();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countStudewnt(){
        long count = studentServ.contStudent();
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
    @GetMapping("/byYear")
    public ResponseEntity<Collection<?>> findNbrStudentByYear(){
        Collection<?> collect = studentServ.findNbrStudentByYear();
        return new ResponseEntity<>(collect,HttpStatus.OK);
    }
}
