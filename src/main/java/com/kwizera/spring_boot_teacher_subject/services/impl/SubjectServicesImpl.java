package com.kwizera.spring_boot_teacher_subject.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.SubjectEntity;
import com.kwizera.spring_boot_teacher_subject.repositories.SubjectRepository;
import com.kwizera.spring_boot_teacher_subject.services.SubjectServices;

@Service
public class SubjectServicesImpl implements SubjectServices {

    private SubjectRepository subjectRepository;

    public SubjectServicesImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Optional<SubjectEntity> findSubject(String id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<SubjectEntity> findAllSubjects() {
        return StreamSupport.stream(subjectRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Page<SubjectEntity> findAllSubjectsPaginated(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    @Override
    public SubjectEntity createSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public boolean subjectExists(String id) {
        return subjectRepository.existsById(id);
    }

    @Override
    public void deleteSubject(String id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectEntity updateSubject(String id, SubjectEntity subjectEntity) {
        subjectEntity.setId(id);

        return subjectRepository.findById(id).map(existingSubject -> {
            Optional.ofNullable(subjectEntity.getCode()).ifPresent(existingSubject::setCode);
            Optional.ofNullable(subjectEntity.getTeacherEntity()).ifPresent(existingSubject::setTeacherEntity);

            return subjectRepository.save(existingSubject);
        }).orElseThrow(() -> new RuntimeException("Subject not found"));
    }

}
