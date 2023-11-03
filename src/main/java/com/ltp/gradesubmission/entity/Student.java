package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @NonNull
    @Column(name="name", nullable =false)
    private String name;

    @NonNull
    @Column(name="birth_date",nullable=false)
    private LocalDate birthDate;


    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;
}
