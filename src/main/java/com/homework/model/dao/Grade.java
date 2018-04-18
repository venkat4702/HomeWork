package com.homework.model.dao;

import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table
public class Grade {

    private UUID id;

    private String gradeId;
    private String grade;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", gradeId='" + gradeId + '\'' +
                ", grade='" + grade + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade)) return false;
        Grade grade1 = (Grade) o;
        return Objects.equals(id, grade1.id) &&
                Objects.equals(gradeId, grade1.gradeId) &&
                Objects.equals(grade, grade1.grade) &&
                Objects.equals(description, grade1.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gradeId, grade, description);
    }
}
