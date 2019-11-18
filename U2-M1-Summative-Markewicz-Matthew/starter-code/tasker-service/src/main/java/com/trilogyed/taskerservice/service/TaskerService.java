package com.trilogyed.taskerservice.service;

import com.trilogyed.taskerservice.dao.TaskerDao;
import com.trilogyed.taskerservice.fiegn.AdserverFeignClient;
import com.trilogyed.taskerservice.model.Task;
import com.trilogyed.taskerservice.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        return null;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        return null;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(task.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {

    }
}
