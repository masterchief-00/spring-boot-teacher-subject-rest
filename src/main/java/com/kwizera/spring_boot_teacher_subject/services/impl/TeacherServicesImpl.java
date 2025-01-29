package com.kwizera.spring_boot_teacher_subject.services.impl;

import java.util.List;
import java.util.Optional;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.TeacherEntity;
import com.kwizera.spring_boot_teacher_subject.services.TeacherServices;

public class TeacherServicesImpl implements TeacherServices {

    @Override
    public Optional<TeacherEntity> findTeacher(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTeacher'");
    }

    @Override
    public List<TeacherEntity> findTeachers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findTeachers'");
    }

    @Override
    public TeacherEntity createTeacher(TeacherEntity teacherEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createTeacher'");
    }

    @Override
    public TeacherEntity updateTeacher(String id, TeacherEntity teacherEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateTeacher'");
    }

    @Override
    public boolean teacherExists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'teacherExists'");
    }

    @Override
    public void deleteTeacher(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteTeacher'");
    }

}
