package com.trilogyed.taskerservice.service;

import com.trilogyed.taskerservice.dao.TaskerDao;
import com.trilogyed.taskerservice.fiegn.AdserverFeignClient;
import com.trilogyed.taskerservice.model.Task;
import com.trilogyed.taskerservice.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskerService {

    TaskerDao dao;

    @Autowired
    AdserverFeignClient adserverFeignClient;

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        String ad = adserverFeignClient.getAdFromService();
        tvm.setAdvertisement(ad);

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> tasks = dao.getAllTasks();
        List<TaskViewModel> taskViewModels = tasks.stream()
                .map(task -> buildTaskViewModel(task, adserverFeignClient.getAdFromService()))
                .collect(Collectors.toList());
        return taskViewModels;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tasks = dao.getTasksByCategory(category);
        List<TaskViewModel> taskViewModels = tasks.stream()
                .map(task -> buildTaskViewModel(task, adserverFeignClient.getAdFromService()))
                .collect(Collectors.toList());
        return taskViewModels;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        String ad = adserverFeignClient.getAdFromService();
        taskViewModel.setAdvertisement(ad);

        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);
    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCategory(taskViewModel.getCategory());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        dao.updateTask(task);
    }

    private TaskViewModel buildTaskViewModel(Task task, String ad) {
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setAdvertisement(ad);
        return taskViewModel;
    }
}
