package com.homework.model.dao;

import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Task {

    private UUID id;

    private String taskId;
    private String task;
    private String description;
//    private String gradeId;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
