package com.example.jpatest.todoList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {
    
    @Autowired
    private ToDoListRepository repository;

    public List<ToDoList> findAll() {
        return repository.findAll();
    }

    public Optional<ToDoList> findById(Long id) {
        return repository.findById(id);
    }

    public ToDoList save(ToDoList todoList) {
        return repository.save(todoList);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
