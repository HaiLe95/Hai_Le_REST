package com.rest.client.model;

public class CourseModel {

    private String title;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CourseModel{");
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
