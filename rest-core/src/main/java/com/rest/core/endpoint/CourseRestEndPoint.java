package com.rest.core.endpoint;

import com.rest.api.dto.CourseDTO;
import com.rest.api.endpiont.CourseEndPoint;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateCourseParameter;
import com.rest.api.response.GeneralResponse;
import com.rest.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseRestEndPoint implements CourseEndPoint {

    @Autowired
    private CourseService service;


    public GeneralResponse<Long> createCourse(GeneralRequest<CreateCourseParameter> params) {
        return new GeneralResponse<Long>("200", service.create(params.getParameters()));
    }

    public GeneralResponse<CourseDTO> getCourse(Long id) {
        service.get(id);
        return new GeneralResponse<CourseDTO>("200", service.get(id));
    }

    public GeneralResponse<Void> updateCourse(Long id, GeneralRequest<CreateCourseParameter> params) {
        service.update(id, params.getParameters());
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<Void> deleteCourse(Long id) {
        service.delete(id);
        return new GeneralResponse<Void>("200", null);
    }
}
