package com.trilogyed.taskerservice.controller;

import com.trilogyed.taskerservice.model.TaskViewModel;
import com.trilogyed.taskerservice.service.TaskerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}
