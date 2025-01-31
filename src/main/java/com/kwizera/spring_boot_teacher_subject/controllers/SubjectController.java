package com.kwizera.spring_boot_teacher_subject.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwizera.spring_boot_teacher_subject.domain.DTO.SubjectDTO;
import com.kwizera.spring_boot_teacher_subject.domain.Entities.SubjectEntity;
import com.kwizera.spring_boot_teacher_subject.mappers.Mapper;
import com.kwizera.spring_boot_teacher_subject.services.SubjectServices;

@RestController
public class SubjectController {

    private Mapper<SubjectEntity, SubjectDTO> subjectMapper;

    private SubjectServices subjectServices;

    public SubjectController(Mapper<SubjectEntity, SubjectDTO> subjectMapper, SubjectServices subjectServices) {
        this.subjectMapper = subjectMapper;
        this.subjectServices = subjectServices;
    }

    @PostMapping(path = "/subjects")
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectEntity savedSubjectEntity = subjectServices.createSubject(subjectMapper.mapFrom(subjectDTO));

        return new ResponseEntity<>(subjectMapper.mapTo(savedSubjectEntity), HttpStatus.CREATED);
    }

    @GetMapping(path = "/subjects")
    public List<SubjectDTO> listSubjects() {

        List<SubjectEntity> allSubjects = subjectServices.findAllSubjects();

        return allSubjects.stream().map(subjectMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "subjects/paginated")
    public Page<SubjectDTO> paginateSubjects(Pageable pageable) {
        Page<SubjectEntity> allSubjects = subjectServices.findAllSubjectsPaginated(pageable);

        return allSubjects.map(subjectMapper::mapTo);
    }

    @GetMapping(path = "/subjects/{id}")
    public ResponseEntity<SubjectDTO> findSubject(@PathVariable("id") String id) {
        Optional<SubjectEntity> foundSubject = subjectServices.findSubject(id);

        return foundSubject.map(subject -> {
            return new ResponseEntity<>(subjectMapper.mapTo(subject), HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping(path = "/subjects/{id}")
    public ResponseEntity<SubjectDTO> updateSubject(@PathVariable("id") String id, @RequestBody SubjectDTO subjectDTO) {
        if (!subjectServices.subjectExists(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        SubjectEntity subjectEntity = subjectMapper.mapFrom(subjectDTO);

        SubjectEntity savedSubjectEntity = subjectServices.updateSubject(id, subjectEntity);

        return new ResponseEntity<>(subjectMapper.mapTo(savedSubjectEntity), HttpStatus.OK);
    }

    @DeleteMapping(path = "/subjects/{id}")
    public ResponseEntity<HttpStatus> deleteSubject(@PathVariable("id") String id) {
        subjectServices.deleteSubject(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
