package com.example.jpatest;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.jpatest.task.Task;
import com.example.jpatest.task.TaskRepository;
import com.example.jpatest.todoList.ToDoList;
import com.example.jpatest.todoList.ToDoListRepository;

@Component
public class Seeders implements ApplicationRunner {
    private final TaskRepository taskRepository;
    private final ToDoListRepository toDoListRepository;

    public Seeders(TaskRepository taskRepository, ToDoListRepository toDoListRepository) {
        this.taskRepository = taskRepository;
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seed(taskRepository, toDoListRepository);
    }

    public static void seed(TaskRepository taskRepository, ToDoListRepository toDoListRepository) {
        // Clear existing tasks and to-do lists
        taskRepository.deleteAll();
        toDoListRepository.deleteAll();

        // Create ToDoLists
        ToDoList groceries = new ToDoList("Groceries");
        ToDoList work = new ToDoList("Work");
        ToDoList home = new ToDoList("Home");

        toDoListRepository.save(groceries);
        toDoListRepository.save(work);
        toDoListRepository.save(home);

        // Create Tasks
        taskRepository.save(new Task("Buy milk", "Go to the store and buy milk", "Pending", groceries));
        taskRepository.save(new Task("Clean the house", "Clean the house before the guests arrive", "Pending", home));
        taskRepository.save(new Task("Finish the project", "Finish the project before the deadline", "Pending", work));
    }
}