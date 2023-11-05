package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GradeRepository extends CrudRepository<Grade,Long> {
    Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
}