package com.rest.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @Column(name = "COURSE_ID")
    @SequenceGenerator(
            name = "courseId",
            sequenceName = "SEQ_COURSE_ID",
            initialValue = 1,
            allocationSize = 50
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseId"
    )
    private Long id;

    @Column
    private String title;


    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "courseId",
            cascade = { CascadeType.REMOVE },
            targetEntity = Group.class
    )
    private List<Group> groups = new ArrayList();

    public Course() {}
    public Course(String title) {
        this.title = title;
    }

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
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
