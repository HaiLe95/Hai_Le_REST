package com.rest.core.endpoint;

import com.rest.api.dto.GroupDTO;
import com.rest.api.endpiont.GroupEndPoint;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateGroupParameter;
import com.rest.api.response.GeneralResponse;
import com.rest.core.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupRestEndPoint implements GroupEndPoint {

    @Autowired
    private GroupService service;

    public GeneralResponse<Long> createStudent(@RequestBody GeneralRequest<CreateGroupParameter> params, Long courseMappingId) {
        return new GeneralResponse<Long>("200", service.create(params.getParameters(), courseMappingId));
    }

    public GeneralResponse<GroupDTO> getGroup(Long groupId) {
        service.get(groupId);
        return new GeneralResponse<GroupDTO>("200", service.get(groupId));
    }

    public GeneralResponse<Void> updateGroup(Long groupId, GeneralRequest<CreateGroupParameter> params) {
        service.update(groupId, params.getParameters());
        return new GeneralResponse<Void>("200", null);
    }

    public GeneralResponse<Void> deleteGroup(Long groupId) {
        service.delete(groupId);
        return new GeneralResponse<Void>("200", null);
    }
}
