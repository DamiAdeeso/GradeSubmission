package com.ltp.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Past;
import lombok.*;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.PathVariable;

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
    @Past(message = "Birth date cannot be in the past")
    @Column(name="birth_date",nullable=false)
    private LocalDate birthDate;


    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;
}
