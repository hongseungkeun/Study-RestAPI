package com.example.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Task {
    Long id;
    String title;

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

    @Builder(builderMethodName = "CreateNewTask")
    public Task(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Task() {
    }
}
