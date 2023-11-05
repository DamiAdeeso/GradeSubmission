package com.ltp.gradesubmission.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="score")
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(name="student_id",referencedColumnName = "id",nullable = false)
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name="course_id",referencedColumnName = "id",nullable = false)
    private Course course;

}
