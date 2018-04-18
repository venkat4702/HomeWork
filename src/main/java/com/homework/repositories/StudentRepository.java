package com.homework.repositories;

import com.homework.model.dao.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends CassandraRepository<Student, String> {

    @Override
    List<Student> findAll();

    Student findByProfileId(String profileId);

    @Query("SELECT * FROM student WHERE studentId = ?0 ALLOW FILTERING")
    Student findStudentByStudentId(String studentId);

    @Query("SELECT * FROM student WHERE profileId = ?0 ALLOW FILTERING")
    Student findStudentByProfileId(UUID profileId);

}
