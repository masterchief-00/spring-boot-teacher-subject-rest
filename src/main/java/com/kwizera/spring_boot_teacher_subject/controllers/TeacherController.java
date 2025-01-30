package com.kwizera.spring_boot_teacher_subject.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kwizera.spring_boot_teacher_subject.domain.DTO.TeacherDTO;
import com.kwizera.spring_boot_teacher_subject.domain.Entities.TeacherEntity;
import com.kwizera.spring_boot_teacher_subject.mappers.Mapper;
import com.kwizera.spring_boot_teacher_subject.services.TeacherServices;

@RestController
public class TeacherController {

    private Mapper<TeacherEntity, TeacherDTO> teacherMapper;
    private TeacherServices teacherServices;

    public TeacherController(Mapper<TeacherEntity, TeacherDTO> teacherMapper, TeacherServices teacherServices) {
        this.teacherMapper = teacherMapper;
        this.teacherServices = teacherServices;
    }

    @PostMapping(path = "/teachers")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        TeacherEntity teacherEntity = teacherMapper.mapFrom(teacherDTO);

        TeacherEntity createdTeacher = teacherServices.createTeacher(teacherEntity);

        return new ResponseEntity<>(teacherMapper.mapTo(createdTeacher), HttpStatus.CREATED);

    }

    @GetMapping(path = "/teachers")
    public List<TeacherDTO> listTeachers() {
        List<TeacherEntity> allTeachers = teacherServices.findTeachers();

        return allTeachers.stream().map(teacherMapper::mapTo).collect(Collectors.toList());
    }

    @GetMapping(path = "/teachers/{id}")
    public ResponseEntity<TeacherDTO> findTeacher(@PathVariable("id") String id) {
        Optional<TeacherEntity> foundTeacher = teacherServices.findTeacher(id);

        return foundTeacher.map(teacherEntity -> {
            TeacherDTO teacherDTO = teacherMapper.mapTo(teacherEntity);

            return new ResponseEntity<>(teacherDTO, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/teachers/{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable("id") String id) {
        teacherServices.deleteTeacher(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
