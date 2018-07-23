package com.rest.client.controller;

import com.rest.api.dto.StudentDTO;
import com.rest.client.feign.RestApiFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {

    @Autowired
    private RestApiFeignClient feignClient;

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public StudentDTO getById(@RequestParam("id") Long id) {
        return feignClient.getStudent(id).getPayLoad();
    }

}
