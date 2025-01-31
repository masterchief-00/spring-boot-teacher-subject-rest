package com.kwizera.spring_boot_teacher_subject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.TeacherEntity;

public interface TeacherServices {

    Optional<TeacherEntity> findTeacher(String id);

    List<TeacherEntity> findTeachers();

    Page<TeacherEntity> findTeachersPaginated(Pageable pageable);

    TeacherEntity createTeacher(TeacherEntity teacherEntity);

    TeacherEntity updateTeacher(String id, TeacherEntity teacherEntity);

    boolean teacherExists(String id);

    void deleteTeacher(String id);
}
