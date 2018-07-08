package com.rest.core.service;

import com.rest.api.dto.StudentDTO;
import com.rest.api.request.parameters.CreateStudentParameter;

public interface StudentService {

    long create(CreateStudentParameter params);

    StudentDTO get(Long id);

    void delete(Long id);
}
