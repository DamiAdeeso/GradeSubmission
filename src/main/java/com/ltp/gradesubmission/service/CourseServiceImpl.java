package com.ltp.gradesubmission.service;

import java.util.List;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    CourseRepository courseRepository;

    @Override
    public Course getCourse(Long id) {

        return courseRepository.findById(id).get();
    }

    @Override
    public Course saveCourse(Course course) {

       return  courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {

        return (List<Course>) courseRepository.findAll();
    }

}
