package com.ltp.gradesubmission.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.ErrorResponse;
import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import com.ltp.gradesubmission.service.GradeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.gradesubmission.entity.Grade;
@AllArgsConstructor
@RestController
@RequestMapping("/grade")
@Validated
public class GradeController {

    GradeService gradeService;
    StudentRepository studentRepository;
    GradeRepository gradeRepository;

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
        return new ResponseEntity<>(gradeService.getGrade(studentId,courseId),HttpStatus.OK);
    }

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<?> saveGrade(@RequestBody @Valid Grade grade, BindingResult bindingResult, @PathVariable Long studentId, @PathVariable Long courseId) {
        ErrorResponse response = respondError(bindingResult);
        ResponseEntity<?> responseEntity = (response == null)
                ? new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED)
                : new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @PutMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Grade> updateGrade(@RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {

        return new ResponseEntity<>(gradeService.updateGrade(grade.getScore(),studentId,courseId), HttpStatus.OK);
    }

    @DeleteMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
        gradeService.deleteGrade(studentId,courseId  );
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId) {
        return new ResponseEntity<>(gradeService.getStudentGrades(studentId),HttpStatus.OK);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId) {
        return new ResponseEntity<>(gradeService.getCourseGrades(courseId),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grade>> getGrades() {
        return new ResponseEntity<>(gradeService.getAllGrades(),HttpStatus.OK);
    }

    static ErrorResponse respondError(BindingResult bindingResult){
        List<String> errors = new ArrayList<>();
        if(bindingResult.hasErrors()){
            for(FieldError fieldError:bindingResult.getFieldErrors()){
                errors.add(fieldError.getDefaultMessage());
            }
            return  new ErrorResponse(errors);

        }
        return new ErrorResponse(null);
    }

}
