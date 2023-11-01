package com.ltp.gradesubmission.entity;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Course {

    private Long id;
    private String subject;
    private String code;
    private String description;
}
