package com.rest.core.service;

import com.rest.api.dto.CourseDTO;
import com.rest.api.request.parameters.CreateCourseParameter;

import java.util.List;

public interface CourseService {

    long create(CreateCourseParameter params);

    CourseDTO get(Long id);

    void update(Long id, CreateCourseParameter params);

    void delete(Long id);

    List<CourseDTO> findAll();

}
