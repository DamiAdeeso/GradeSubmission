package com.ltp.gradesubmission.service;

import java.sql.SQLOutput;
import java.util.List;

import com.ltp.gradesubmission.entity.Grade;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {


    StudentRepository studentRepository;

    @Override
    public Student getStudent(Long id) {

        printGrades(studentRepository.findById(id).get());
        return studentRepository.findById(id).get();
    }

    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {

        return (List<Student>) studentRepository.findAll();
    }

        void printGrades(Student student){
            for (Grade grade: student.getGrades()) {
                System.out.println(grade.getScore());
            }
        }
    

}