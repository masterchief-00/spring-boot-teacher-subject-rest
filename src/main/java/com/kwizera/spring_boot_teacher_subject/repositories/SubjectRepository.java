package com.kwizera.spring_boot_teacher_subject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kwizera.spring_boot_teacher_subject.domain.Entities.SubjectEntity;

@Repository
public interface SubjectRepository
        extends CrudRepository<SubjectEntity, String>, PagingAndSortingRepository<SubjectEntity, String> {

}
