package com.rest.core.service.impl;

import com.rest.api.dto.StudentDTO;
import com.rest.api.request.parameters.CreateStudentParameter;
import com.rest.core.dao.GroupRepository;
import com.rest.core.dao.StudentRepository;
import com.rest.core.domain.Group;
import com.rest.core.domain.Student;
import com.rest.core.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private GroupRepository groupRepository;

    public long create(CreateStudentParameter params, long groupMappingId) {
        Student student = new Student();
        student.setfName(params.getfName());
        student.setlName(params.getlName());
        student.setAge(params.getAge());

        Group group = groupRepository.getOne(groupMappingId);
        group.getStudents().add(student);

        return repository.saveAndFlush(student).getId();
    }

    public StudentDTO get(Long id) {
        Student student = repository.findOne(id);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setfName(student.getfName());
        studentDTO.setlName(student.getlName());
        studentDTO.setAge(student.getAge());
        return studentDTO;
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void update(Long id, CreateStudentParameter params) {
        Student student = repository.getOne(id);
        student.setfName(params.getfName());
        student.setlName(params.getlName());
        student.setAge(params.getAge());
        repository.save(student);
        repository.flush();
    }

    public List<StudentDTO> findAll() {
        List<Student> students = repository.findAll();
        List<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setfName(student.getfName());
            studentDTO.setlName(student.getlName());
            studentDTO.setAge(student.getAge());
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }
}
