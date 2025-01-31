package com.kwizera.spring_boot_teacher_subject.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.TeacherEntity;
import com.kwizera.spring_boot_teacher_subject.repositories.TeacherRepository;
import com.kwizera.spring_boot_teacher_subject.services.TeacherServices;

@Service
public class TeacherServicesImpl implements TeacherServices {

    private TeacherRepository teacherRepository;

    public TeacherServicesImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Optional<TeacherEntity> findTeacher(String id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<TeacherEntity> findTeachers() {
        return StreamSupport.stream(teacherRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Page<TeacherEntity> findTeachersPaginated(Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }

    @Override
    public TeacherEntity createTeacher(TeacherEntity teacherEntity) {
        return teacherRepository.save(teacherEntity);
    }

    @Override
    public TeacherEntity updateTeacher(String id, TeacherEntity teacherEntity) {
        teacherEntity.setId(id);

        return teacherRepository.findById(id).map(existingTeacher -> {
            Optional.ofNullable(teacherEntity.getName()).ifPresent(existingTeacher::setName);
            Optional.ofNullable(teacherEntity.getAge()).ifPresent(existingTeacher::setAge);
            Optional.ofNullable(teacherEntity.getEmail()).ifPresent(existingTeacher::setEmail);

            return teacherRepository.save(existingTeacher);
        }).orElseThrow(() -> new RuntimeException("Teacher doesn't exists"));
    }

    @Override
    public boolean teacherExists(String id) {
        return teacherRepository.existsById(id);
    }

    @Override
    public void deleteTeacher(String id) {
        teacherRepository.deleteById(id);
    }

}
