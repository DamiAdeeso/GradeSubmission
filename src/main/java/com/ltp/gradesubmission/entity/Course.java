package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="course")

public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NonNull
    @Column(name="subject",nullable = false)
    private String subject;

    @NonNull
    @Column(name="code", nullable = false)
    private String code;

    @NonNull
    @Column(name = "description",nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Grade> grades;
}
