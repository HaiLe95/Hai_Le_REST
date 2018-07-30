package com.rest.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @Column(name = "GROUP_ID")
    @SequenceGenerator(
            name = "groupId",
            sequenceName = "SEQ_GROUP_ID",
            initialValue = 1,
            allocationSize = 25
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "groupId"
    )
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            targetEntity = Course.class
    )
    @JoinColumn(
            name = "COURSE_ID",
            nullable = false
    )
    private Course courseId;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "groupId",
            cascade = { CascadeType.REMOVE },
            targetEntity = Student.class
    )
    private List<Student> students = new ArrayList();

    @Column
    private String title;


    public Group() {}
    public Group(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Course getCourseId() {
        return courseId;
    }
    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}