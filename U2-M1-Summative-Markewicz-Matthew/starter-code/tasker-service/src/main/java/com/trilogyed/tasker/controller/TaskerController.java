package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @GetMapping(value = "/tasks")
    public List<Task> getAllTasks() {
        return null;
    }

    @GetMapping(value = "/tasks/{id}")
    public Task getTaskById(@PathVariable int id) {
        return null;
    }

    @GetMapping(value = "/tasks/category/{category}")
    public Task getTaskByCategory(@PathVariable String category) {
        return null;
    }

    @PostMapping(value = "/tasks")
    public Task postTask(@RequestBody Task task) {
        return null;
    }

    @PutMapping(value = "/tasks")
    public void putTask(@RequestBody Task task) {
        //
    }

    @DeleteMapping(value = "/tasks/{id}")
    public void deleteTask(@PathVariable int id) {
        //
    }


}
