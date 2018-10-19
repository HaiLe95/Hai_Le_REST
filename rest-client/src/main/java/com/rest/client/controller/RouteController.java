package com.rest.client.controller;

import com.rest.client.model.CourseModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouteController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(Model model) {
        model.addAttribute("course", new CourseModel());
        return "index";
    }

}
