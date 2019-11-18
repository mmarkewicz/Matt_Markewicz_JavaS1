package com.trilogyed.taskerservice.controller;

import com.trilogyed.taskerservice.model.TaskViewModel;
import com.trilogyed.taskerservice.service.TaskerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskerController {
    @Autowired
    TaskerService service;

    public TaskerController(TaskerService service) {
        this.service = service;
    }

    @GetMapping(value = "/task/{id}")
    public TaskViewModel getTask(@PathVariable int id) {
        return service.fetchTask(id);
    }

    @GetMapping(value = "/tasks")
    public List<TaskViewModel> getAllTasks() {
        return service.fetchAllTasks();
    }

    @GetMapping(value = "/tasks/category/{category}")
    public List<TaskViewModel> getTasksByCategory(@PathVariable String category) {
        return service.fetchTasksByCategory(category);
    }

    @PostMapping(value = "/tasks")
    public TaskViewModel addTask(@RequestBody TaskViewModel taskViewModel) {
        return service.newTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }

    @PutMapping(value = "/tasks")
    public void updateTask(@RequestBody TaskViewModel taskViewModel) {
        service.updateTask(taskViewModel);
    }
}
