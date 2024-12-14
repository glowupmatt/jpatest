package com.example.jpatest.todoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todolist")
public class ToDoListController {
    
    @Autowired
    private TodoListService service;

    @GetMapping
    public List<ToDoList> getAllToDoList() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ToDoList> getToDoListById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ToDoList createToDoList(@RequestBody ToDoList todoList) {
        return service.save(todoList);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoList(@PathVariable Long id) {
        service.deleteById(id);
    }
}
