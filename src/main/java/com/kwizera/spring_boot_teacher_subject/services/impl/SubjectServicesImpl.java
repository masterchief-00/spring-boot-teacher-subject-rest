package com.kwizera.spring_boot_teacher_subject.services.impl;

import java.util.List;
import java.util.Optional;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.SubjectEntity;
import com.kwizera.spring_boot_teacher_subject.services.SubjectServices;

public class SubjectServicesImpl implements SubjectServices {

    @Override
    public Optional<SubjectEntity> findSubject(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSubject'");
    }

    @Override
    public List<SubjectEntity> findAllSubjects() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllSubjects'");
    }

    @Override
    public SubjectEntity createSubject(SubjectEntity subjectEntity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSubject'");
    }

    @Override
    public boolean subjectExists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subjectExists'");
    }

    @Override
    public void deleteSubject(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSubject'");
    }

}
