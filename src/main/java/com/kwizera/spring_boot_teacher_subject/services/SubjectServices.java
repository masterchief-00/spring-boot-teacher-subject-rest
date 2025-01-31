package com.kwizera.spring_boot_teacher_subject.services;

import java.util.List;
import java.util.Optional;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.SubjectEntity;

public interface SubjectServices {

    Optional<SubjectEntity> findSubject(String id);

    List<SubjectEntity> findAllSubjects();

    SubjectEntity createSubject(SubjectEntity subjectEntity);

    SubjectEntity updateSubject(String id, SubjectEntity subjectEntity);

    boolean subjectExists(String id);

    void deleteSubject(String id);

}
