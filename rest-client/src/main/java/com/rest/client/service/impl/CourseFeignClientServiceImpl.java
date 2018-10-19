package com.rest.client.service.impl;

import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateCourseParameter;
import com.rest.client.feign.CourseClientApi;
import com.rest.client.model.CourseModel;
import com.rest.client.service.CourseFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseFeignClientServiceImpl implements CourseFeignClientService {

    @Autowired
    private CourseClientApi courseClientApi;


    public void create(CourseModel model) {
        CreateCourseParameter parameter = new CreateCourseParameter();
        parameter.setTitle(model.getTitle());

        GeneralRequest<CreateCourseParameter> request =
                new GeneralRequest<CreateCourseParameter>();
        request.setParameters(parameter);
        courseClientApi.createCourseRecord(request);
    }
}
