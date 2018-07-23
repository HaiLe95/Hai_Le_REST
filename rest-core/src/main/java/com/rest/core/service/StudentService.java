package com.rest.core.service;

import com.rest.api.dto.StudentDTO;
import com.rest.api.request.parameters.CreateStudentParameter;
import com.rest.core.domain.Student;

import java.util.List;

public interface StudentService {

    long create(CreateStudentParameter params);

    StudentDTO get(Long id);

    void delete(Long id);

    void update(Long id, CreateStudentParameter params);

    List<StudentDTO> findAll();
}
