package com.rest.core.service;

import com.rest.api.dto.StudentDTO;
import com.rest.api.request.parameters.CreateStudentParameter;

import java.util.List;

public interface StudentService {

    long create(CreateStudentParameter params, long group);

    StudentDTO get(Long id);

    void delete(Long id);

    void update(Long id, CreateStudentParameter params, long groupId);

    List<StudentDTO> findAll();
}
