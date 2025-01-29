package com.kwizera.spring_boot_teacher_subject.domain.Entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class SubjectEntity {

    @Id
    @UuidGenerator
    private String id;

    private String code;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;
}
