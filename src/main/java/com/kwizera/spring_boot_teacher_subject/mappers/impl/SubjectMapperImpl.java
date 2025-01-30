package com.kwizera.spring_boot_teacher_subject.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.kwizera.spring_boot_teacher_subject.domain.DTO.SubjectDTO;
import com.kwizera.spring_boot_teacher_subject.domain.Entities.SubjectEntity;
import com.kwizera.spring_boot_teacher_subject.mappers.Mapper;

@Component
public class SubjectMapperImpl implements Mapper<SubjectEntity, SubjectDTO> {

    public ModelMapper modelMapper;

    public SubjectMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public SubjectDTO mapTo(SubjectEntity subjectEntity) {
        return modelMapper.map(subjectEntity, SubjectDTO.class);
    }

    @Override
    public SubjectEntity mapFrom(SubjectDTO subjectDTO) {
        return modelMapper.map(subjectDTO, SubjectEntity.class);
    }

}
