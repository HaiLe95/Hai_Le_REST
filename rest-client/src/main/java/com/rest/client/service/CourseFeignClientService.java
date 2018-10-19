package com.rest.client.service;

import com.rest.client.model.CourseModel;

public interface CourseFeignClientService {

    void create(CourseModel model);

}
