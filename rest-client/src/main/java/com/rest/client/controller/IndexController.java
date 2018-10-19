package com.rest.client.controller;

import com.rest.client.model.CourseModel;
import com.rest.client.service.CourseFeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    private CourseFeignClientService courseFeignClientService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createCourse(@ModelAttribute CourseModel model) {
        courseFeignClientService.create(model);
        return "redirect:/";
    }

}
