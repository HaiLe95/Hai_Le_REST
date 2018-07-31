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

import java.util.List;

@RestController
public class StudentRestEndpoint implements StudentEndpoint {

    @Autowired
    private StudentService service;

    public GeneralResponse<Long> createStudent(
            @RequestBody GeneralRequest<CreateStudentParameter> params, long groupMappingId) {
        return new GeneralResponse<Long>("200", service.create(params.getParameters(), groupMappingId));
    }

    public GeneralResponse<StudentDTO> getStudent(Long studentId) {
        service.get(studentId);
        return new GeneralResponse<StudentDTO>("200", service.get(studentId));
    }

    public GeneralResponse<Void> updateStudent(Long studentId,
                                               @RequestBody GeneralRequest<CreateStudentParameter> params) {
        service.update(studentId, params.getParameters());
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<Void> deleteStudent(Long studentId) {
        service.delete(studentId);
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<List<StudentDTO>> getAllStudents() {
        return new GeneralResponse<List<StudentDTO>>("200", service.findAll());
    }
}
