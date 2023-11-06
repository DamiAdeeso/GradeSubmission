package com.ltp.gradesubmission.web;

import com.ltp.gradesubmission.exception.ErrorResponse;
import com.ltp.gradesubmission.service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.gradesubmission.entity.Course;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@Validated
@RequestMapping("/course")
public class CourseController {

    CourseService courseService;
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {

        return new ResponseEntity<>(courseService.getCourse(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody @Valid Course course, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            List<String> errors = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                errors.add(fieldError.getDefaultMessage());
            }
            ErrorResponse errorResponse = new ErrorResponse(errors);
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCourses() {

        return new ResponseEntity<>(courseService.getCourses(),HttpStatus.OK);
    }

}
