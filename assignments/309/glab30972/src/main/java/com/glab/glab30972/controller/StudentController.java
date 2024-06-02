package com.glab.glab30972.controller;

import com.glab.glab30972.model.Student;
import com.glab.glab30972.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    @GetMapping("/students/{accountNumber}")
    public Student getStudentById(@PathVariable long accountNumber) {
        return studentRepository.findByAccountNumber(accountNumber);
    }

    @PostMapping("/AddStudent")
    public void addStudent(@RequestBody Student newStudent) {
        studentRepository.save(newStudent);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
    }

    @DeleteMapping("/students")
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @PutMapping("/updateStudentById/{id}")
    public void updateStudentById(@PathVariable("id") long studentId, @RequestBody Student studentObj) {
        Optional<Student> studentData = studentRepository.findById(studentId);
        if(studentData.isPresent()){
            Student updatedStudent = studentData.get();
            updatedStudent.setName(studentObj.getName());
            updatedStudent.setMarks(studentObj.getMarks());
            updatedStudent.setAccountNumber(studentObj.getAccountNumber());
            studentRepository.save(updatedStudent);
        }
    }
}
