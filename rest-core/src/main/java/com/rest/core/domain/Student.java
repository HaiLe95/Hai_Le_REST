package com.rest.core.domain;


import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String fName;

    @Column
    private String lName;

    @Column
    private Integer age;

//    @ManyToOne (
//            fetch = FetchType.EAGER,
//            targetEntity = Group.class
//    )
//    @JoinColumn(
//            name = "GROUP_ID",
//            nullable = false
//    )
//    private Group groupId;

    public Student() {}

    public Student(String fName, String lName, Integer age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }
    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
//    public Group getGroupId() {
//        return groupId;
//    }
//    public void setGroupId(Group groupId) {
//        this.groupId = groupId;
//    }
}
