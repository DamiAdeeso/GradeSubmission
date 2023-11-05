package com.ltp.gradesubmission.service;

import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Grade;

public interface GradeService {
    Optional<Grade> getGrade(Long studentId, Long courseId);
    Grade saveGrade(Grade grade, Long studentId, Long courseId);
    Grade updateGrade(String score, Long studentId, Long courseId);
    void deleteGrade(Long studentId, Long courseId);
    List<Grade> getStudentGrades(Long studentId);
    List<Grade> getCourseGrades(Long courseId);
    List<Grade> getAllGrades();
}
