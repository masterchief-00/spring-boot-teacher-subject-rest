package com.kwizera.spring_boot_teacher_subject.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.kwizera.spring_boot_teacher_subject.domain.DTO.TeacherDTO;
import com.kwizera.spring_boot_teacher_subject.domain.Entities.TeacherEntity;
import com.kwizera.spring_boot_teacher_subject.mappers.Mapper;

@Component
public class TeacherMapperImpl implements Mapper<TeacherEntity, TeacherDTO> {

    private ModelMapper modelMapper;

    public TeacherMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TeacherDTO mapTo(TeacherEntity teacherEntity) {
        return modelMapper.map(teacherEntity, TeacherDTO.class);
    }

    @Override
    public TeacherEntity mapFrom(TeacherDTO teacherDTO) {
        return modelMapper.map(teacherDTO, TeacherEntity.class);
    }

}
