package com.rest.api.endpiont;

import com.rest.api.dto.StudentDTO;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateStudentParameter;
import com.rest.api.response.GeneralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@SwaggerDefinition(
        info = @Info(
                description =   "Rest API",
                version =       "1.0.0",
                title =         "Rest API"
        ),
        produces =  MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes =   SwaggerDefinition.Scheme.HTTPS
)
@Api(
        tags =      "Students",
        produces =  MediaType.APPLICATION_JSON_UTF8_VALUE,
        protocols = "https"
)
@RequestMapping("/view/students")
public interface StudentEndpoint {

    @ApiOperation(value = "Student record create")
    @RequestMapping(
            value = "/create",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST
    )
    GeneralResponse<Long> createStudent(
            GeneralRequest<CreateStudentParameter> params, @RequestParam("groupId") long groupMappingId);

    @ApiOperation(value = "Student record delete")
    @RequestMapping(
            value = "/delete",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteStudent(
            @RequestParam("studentId") Long studentId);


    @ApiOperation(value = "Student record get by ID")
    @RequestMapping(
            value = "/get",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    GeneralResponse<StudentDTO> getStudent(
            @RequestParam("studentId") Long studentId
    );

    @ApiOperation(value = "Student record update")
    @RequestMapping(
            value = "/update",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.PUT
    )
    GeneralResponse<Void> updateStudent(
            @RequestParam("studentId") Long studentId, GeneralRequest<CreateStudentParameter> params, long groupMappingId);

    @ApiOperation(value = "Student record getAll")
    @RequestMapping(
            value = "/getAll",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    GeneralResponse<List<StudentDTO>> getAllStudents();



}


