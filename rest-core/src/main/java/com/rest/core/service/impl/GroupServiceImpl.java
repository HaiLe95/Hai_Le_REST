package com.rest.core.service.impl;

import com.rest.api.dto.GroupDTO;
import com.rest.api.dto.StudentDTO;
import com.rest.api.request.parameters.CreateGroupParameter;
import com.rest.core.dao.CourseRepository;
import com.rest.core.dao.GroupRepository;
import com.rest.core.domain.Course;
import com.rest.core.domain.Group;
import com.rest.core.domain.Student;
import com.rest.core.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {


    @Autowired
    private GroupRepository repository;
    @Autowired
    private  CourseRepository courseRepository;

    public long create(CreateGroupParameter params, Long courseMappingId) {
        Group group = new Group();
        group.setTitle(params.getTitle());

        Course course = courseRepository.getOne(courseMappingId);
        course.getGroups().add(group);

        return repository.saveAndFlush(group).getId();
    }

    public GroupDTO get(Long id) {
        Group group = repository.getOne(id);

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setTitle(group.getTitle());
        groupDTO.setId(group.getId());
        groupDTO.setCourseId(group.getCourseId().getId());
        groupDTO.setStudents(getStudentDTO(id));
        return groupDTO;
    }

    /**TODO Check up this method */
    public void delete(Long id) {
        Group group = repository.getOne(id);
        Course course = courseRepository.getOne(group.getCourseId().getId());
        for(Group g : course.getGroups()) {
            if(g.getId() == id) {
                course.getGroups().remove(g);
            }
        }
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
            groupDTO.setStudents(getStudentDTO(group.getId()));
            groupDTOList.add(groupDTO);
        }
        return groupDTOList;
    }

    private List<StudentDTO> getStudentDTO(Long id) {
        Group group = repository.getOne(id);
        List<StudentDTO> listDTO = new ArrayList();
        for(Student student : group.getStudents()) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setfName(student.getfName());
            studentDTO.setlName(student.getlName());
            studentDTO.setAge(student.getAge());
            studentDTO.setId(student.getId());
            listDTO.add(studentDTO);
        }
        return listDTO;
    }

}
