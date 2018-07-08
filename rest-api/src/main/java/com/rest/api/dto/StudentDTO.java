package com.rest.api.dto;

/** DTO - DATA-TRANSFER-OBJECT - основное назначение это
 *                          безопасная передача данных для Front-end
 * */

public class StudentDTO {

    private Long id;

    private String fName;

    private String lName;

    private Integer Age;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getfName() { return fName; }
    public void setfName(String fName) { this.fName = fName; }
    public String getlName() { return lName; }
    public void setlName(String lName) { this.lName = lName; }
    public Integer getAge() { return Age; }
    public void setAge(Integer age) { Age = age; }
}
