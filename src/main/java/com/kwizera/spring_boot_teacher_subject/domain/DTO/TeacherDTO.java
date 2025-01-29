package com.kwizera.spring_boot_teacher_subject.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO {
    private String id;

    private String name;

    private String email;

    private Integer age;
}
