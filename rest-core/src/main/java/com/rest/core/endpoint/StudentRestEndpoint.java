package com.rest.core.endpoint;

import com.rest.api.dto.StudentDTO;
import com.rest.api.endpiont.StudentEndpoint;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateStudentParameter;
import com.rest.api.response.GeneralResponse;
import com.rest.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestEndpoint implements StudentEndpoint {

    @Autowired
    private StudentService service;


    public GeneralResponse<Void> deleteStudent(Long studentId) {
        service.delete(studentId);
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<Long> createStudent(
            @RequestBody
            GeneralRequest<CreateStudentParameter> params) {
        return new GeneralResponse<Long>("200", service.create(params.getParameters()));
    }

    public GeneralResponse<StudentDTO> getStudent(Long studentId) {
        service.get(studentId);
        return new GeneralResponse<StudentDTO>("200", service.get(studentId));
    }
}
