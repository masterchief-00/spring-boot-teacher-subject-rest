package com.kwizera.spring_boot_teacher_subject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.TeacherEntity;

public interface TeacherRepository extends CrudRepository<TeacherEntity, String> {

}
