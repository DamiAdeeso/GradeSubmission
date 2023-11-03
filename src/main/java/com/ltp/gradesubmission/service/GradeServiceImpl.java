package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        return gradeRepository.findByStudentId(studentId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {

        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {
        return null;
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
        
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
        return null;
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return null;
    }

    @Override
    public List<Grade> getAllGrades() {
        return null;
    }

}
