package com.rest.api.dto;

import java.util.List;

public class GroupDTO {

    private Long id;
    private String title;
    private Long courseId;
    private List<StudentDTO> students;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Long getCourseId() { return courseId; }
    public  void setCourseId(Long courseId) { this.courseId = courseId; }
    public List<StudentDTO> getStudents() {
        return students;
    }
    public void setStudents(List<StudentDTO> students) {
        this.students = students;
    }
}
