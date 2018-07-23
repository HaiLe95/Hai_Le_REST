package com.rest.core.service.impl;

import com.rest.api.dto.GroupDTO;
import com.rest.api.request.parameters.CreateGroupParameter;
import com.rest.core.dao.GroupRepository;
import com.rest.core.domain.Group;
import com.rest.core.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {


    @Autowired
    private GroupRepository repository;

    public long create(CreateGroupParameter params) {
        Group group = new Group();
        group.setTitle(params.getTitle());
        return repository.saveAndFlush(group).getId();
    }

    public GroupDTO get(Long id) {
        GroupDTO groupDTO = new GroupDTO();
        Group group = repository.getOne(id);
        groupDTO.setTitle(group.getTitle());
        groupDTO.setId(group.getId());
        return groupDTO;
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void update(Long id, CreateGroupParameter params) {
        Group group = repository.getOne(id);
        group.setTitle(params.getTitle());
        repository.save(group);
        repository.flush();
    }

    public List<GroupDTO> findAll() {
        List<GroupDTO> groupDTOList = new ArrayList();
        for (Group group : repository.findAll()) {
            GroupDTO groupDTO = new GroupDTO();
            groupDTO.setId(group.getId());
            groupDTO.setTitle(group.getTitle());
            groupDTOList.add(groupDTO);
        }
        return groupDTOList;
    }
}
