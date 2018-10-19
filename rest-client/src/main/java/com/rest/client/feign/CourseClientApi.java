package com.rest.client.feign;

import com.rest.api.endpiont.CourseEndPoint;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateCourseParameter;
import com.rest.api.response.GeneralResponse;
import com.rest.client.config.FeignClientConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "CourseAPI",
        url = "http://localhost:3000",
        configuration = FeignClientConfig.class
)
public interface CourseClientApi extends CourseEndPoint {

    @RequestMapping(
            value = "/create",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    GeneralResponse<Long> createCourseRecord(GeneralRequest<CreateCourseParameter> request);

}
