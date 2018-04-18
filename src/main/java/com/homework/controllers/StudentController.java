package com.homework.controllers;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.utils.UUIDs;
import com.homework.model.dao.Student;
import com.homework.model.wireObjects.StudentWire;
import com.homework.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

//    @RequestMapping(value = "/student/profle/{studentId}")
//    public Map<String, String> getStudentProfile(@PathVariable String studentId) {
//        Map<String, String> studentProfile = new HashMap<>();
//
//        studentProfile.put("Student_Id",studentId);
//        studentProfile.put("student_first", "Samanyu");
//        studentProfile.put("student_last", "Badam");
//        studentProfile.put("student_dob", "09/07/2006");
//        studentProfile.put("student_address", "Mason,OH 45040");
//
//        return studentProfile;
//    }

    @RequestMapping("/students")
    public List<Student> getAllStudents() {
        System.out.println("Get all Students");

        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }

    @RequestMapping(value = "/students/profiles/{profileId}")
    public Student getStudentById(@PathVariable String profileId){
        System.out.println("Get student's profile by ID");
        Student student = studentRepository.findStudentByStudentId(profileId);

        return student;
    }

    @PostMapping(value = "/students/create")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentWire studentWire) {
        System.out.println("Create Student: " + studentWire.getFirstName() + "...");
        Student student = new Student();
        student.setProfileId(UUIDs.timeBased());
        student.setStudentId(studentWire.getStudentId());
        student.setFirstName(studentWire.getFirstName());
        student.setLastName(studentWire.getLastName());
        student.setDateOfBirth(LocalDate.fromMillisSinceEpoch(studentWire.getDateOfBirth().getTime()));
        student.setGrade(studentWire.getGrade());
        student.setGender(studentWire.getGender());
        student.setCreatedDate(new Date());
        student.setLastModifiedDate(new Date());
        Student _student = studentRepository.save(student);
        return new ResponseEntity<>(_student, HttpStatus.OK);

    }

    @PutMapping("/students/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") String studentId, @RequestBody Student student) {
        System.out.println("Update Student with ID = " + studentId + "...");

        Student studentData = studentRepository.findStudentByStudentId(studentId);
        if ( studentData == null ) {
            System.out.println("Student with ID = " + studentId + "not found...");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentData.setGrade(student.getGrade());
        studentData.setFirstName(student.getFirstName());
        studentData.setLastName(student.getLastName());
        studentData.setLastModifiedDate(new Date());
        Student updatedStudent = studentRepository.save(studentData);

        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/students/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") String studentId) {
        System.out.println("Delete Student with student Id: " + studentId + "...");
        Student studentData = studentRepository.findStudentByStudentId(studentId);
        if ( studentData == null ) {
            System.out.println("Student with ID = " + studentId + "not found...");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentRepository.delete(studentData);

        return new ResponseEntity<>("Student has been delete!", HttpStatus.OK);
    }

}
