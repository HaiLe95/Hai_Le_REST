package com.rest.core.service;

import com.rest.api.dto.GroupDTO;
import com.rest.api.request.parameters.CreateGroupParameter;

import java.util.List;

public interface GroupService {

    long create(CreateGroupParameter params);

    GroupDTO get(Long id);

    void delete(Long id);

    void update(Long id, CreateGroupParameter params);

    List<GroupDTO> findAll();

}
