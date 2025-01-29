package com.kwizera.spring_boot_teacher_subject.domain.DTO;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.TeacherEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private String id;

    private String code;

    private TeacherEntity teacherEntity;
}
