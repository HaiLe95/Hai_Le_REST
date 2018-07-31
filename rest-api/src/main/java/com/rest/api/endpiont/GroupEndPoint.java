package com.rest.api.endpiont;

import com.rest.api.dto.GroupDTO;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateGroupParameter;
import com.rest.api.response.GeneralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        tags =      "Groups",
        produces =  MediaType.APPLICATION_JSON_UTF8_VALUE,
        protocols = "https"
)
@RequestMapping("/view/groups")
public interface GroupEndPoint {

    @ApiOperation(value = "Group record create")
    @RequestMapping(
            value = "/create",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST
    )
    GeneralResponse<Long> createStudent(
            GeneralRequest<CreateGroupParameter> params, @RequestParam("courseId") Long courseMappingId);

    @ApiOperation(value = "Group record get by ID")
    @RequestMapping(
            value = "/get",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET
    )
    GeneralResponse<GroupDTO> getGroup(
            @RequestParam("groupId") Long groupId
    );

    @ApiOperation(value = "Group record update")
    @RequestMapping(
            value = "/update",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.PUT
    )
    GeneralResponse<Void> updateGroup(
            @RequestParam("groupId") Long groupId,
            GeneralRequest<CreateGroupParameter> params);


    @ApiOperation(value = "Group record delete by ID")
    @RequestMapping(
            value = "/delete",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.DELETE
    )
    GeneralResponse<Void> deleteGroup(
            @RequestParam("groupId") Long groupId
    );
}
