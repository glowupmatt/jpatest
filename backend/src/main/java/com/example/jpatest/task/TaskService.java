package com.example.jpatest.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Task save(Task task) {
        return repository.save(task);
    }
    
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
