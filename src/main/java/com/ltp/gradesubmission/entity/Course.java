package com.ltp.gradesubmission.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @NotBlank(message= "Subject cannot be Blank")
    @Column(name = "subject", nullable = false)
    private String subject;

    @NonNull
    @NotBlank(message="Course code cannot be blank")
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @NonNull
    @Column(name = "description", nullable = false)
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;

}
