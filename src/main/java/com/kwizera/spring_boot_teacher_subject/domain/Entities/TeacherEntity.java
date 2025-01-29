package com.kwizera.spring_boot_teacher_subject.domain.Entities;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    @UuidGenerator
    private String id;

    private String name;

    private String email;

    private Integer age;

}
