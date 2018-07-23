package com.rest.core.service.impl;

import com.rest.api.dto.CourseDTO;
import com.rest.api.request.parameters.CreateCourseParameter;
import com.rest.core.dao.CourseRepository;
import com.rest.core.domain.Course;
import com.rest.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    public long create(CreateCourseParameter params) {
        Course course = new Course();
        course.setTitle(params.getTitle());
        return repository.saveAndFlush(course).getId();
    }

    public CourseDTO get(Long id) {
        CourseDTO courseDTO = new CourseDTO();
        Course course = repository.getOne(id);
        courseDTO.setTitle(course.getTitle());
        courseDTO.setId(course.getId());
        return courseDTO;
    }

    public void update(Long id, CreateCourseParameter params) {
        Course course = repository.getOne(id);
        course.setTitle(params.getTitle());
        repository.save(course);
        repository.flush();
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<CourseDTO> findAll() {
        List<CourseDTO> list = new ArrayList();
        for(Course course : repository.findAll()) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setId(course.getId());
            courseDTO.setTitle(course.getTitle());
            list.add(courseDTO);
        }
        return list;
    }
}
