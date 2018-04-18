package com.homework.repositories;

import com.homework.model.dao.HomeWork;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HomeWorkRepository extends CassandraRepository<HomeWork, String> {

    @Override
    List<HomeWork> findAll();

    @Query("SELECT * FROM HomeWork WHERE studentId = ?0 ALLOW FILTERING")
    List<HomeWork> findHomeWorkByStudentId(String studentId);

    @Query("SELECT * FROM HomeWork WHERE homeworkId = ?0 ALLOW FILTERING")
    HomeWork findHomeWorkById(String homeworkId);

}
