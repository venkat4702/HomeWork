package com.homework.controllers;

import com.datastax.driver.core.utils.UUIDs;
import com.homework.model.dao.HomeWork;
import com.homework.model.dao.Student;
import com.homework.repositories.HomeWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class HomeWorkController {

    @Autowired
    HomeWorkRepository homeWorkRepository;

    @RequestMapping("/homeworks")
    public List<HomeWork> getAllHomeWorks() {
        System.out.println("Get all homeWorks");

        List<HomeWork> homeWorks = new ArrayList<>();
        homeWorkRepository.findAll().forEach(homeWorks::add);

        return homeWorks;
    }

    @RequestMapping("/student/homeworks/{studentId}")
    public List<HomeWork> getStudentHomeWorks(@PathVariable String studentId) {
        System.out.println("Get all homeWorks for the student" + studentId);

        List<HomeWork> homeWorks = new ArrayList<>();
        homeWorkRepository.findHomeWorkByStudentId(studentId).forEach(homeWorks::add);

        return homeWorks;
    }

    @PostMapping(value = "/student/homeworks/create")
    public ResponseEntity<HomeWork> createStudentHomeWork(@Valid @RequestBody HomeWork homeWork) {
        System.out.println("Create Home Work for: " + homeWork.getStudent() + "...");
        homeWork.setId(UUIDs.timeBased());
        homeWork.setStartDate(new Date());
        homeWork.setCreatedDate(new Date());
        homeWork.setStatus("Active");

        HomeWork _homeWork = homeWorkRepository.save(homeWork);

        return new ResponseEntity<>(_homeWork, HttpStatus.OK);
    }

    @PutMapping("/students/homeworks/update/{homeworkId}")
    public ResponseEntity<HomeWork> updateStudentHomeWork(@PathVariable("homeworkId") String homeworkId, @RequestBody HomeWork homeWork) {
        System.out.println("Update Home Work for ID:" + homeworkId + "....");
        HomeWork homeWorkData = homeWorkRepository.findHomeWorkById(homeworkId);
        if ( homeWorkData == null) {
            System.out.println("Home Work with ID = " + homeworkId + "not found...");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        homeWorkData.setStatus(homeWork.getStatus());
        homeWorkData.setLastModifiedDate(new Date());
        homeWorkData.setDescription(homeWork.getDescription());

        HomeWork updatedHomeWork = homeWorkRepository.save(homeWorkData);
        return new ResponseEntity<>(updatedHomeWork, HttpStatus.OK);
    }

}
