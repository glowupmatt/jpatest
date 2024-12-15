package com.example.jpatest.task;

import com.example.jpatest.todoList.ToDoList;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    @JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class, 
    property = "id")
    private ToDoList toDoList;

    public Task() {
    }

    public Task(String title, String description, String status, ToDoList toDoList) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.toDoList = toDoList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ToDoList getToDoListId() {
        return toDoList;
    }

    public void setToDoListId(ToDoList toDoListId) {
        this.toDoList = toDoListId;
    }
}
