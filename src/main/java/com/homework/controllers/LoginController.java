package com.homework.controllers;

import com.homework.model.dao.Student;
import com.homework.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/login")
    public List<Student> getAllStudents() {
        System.out.println("Get all Students");

        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }
}
