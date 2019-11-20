package com.trilogyed.taskerservice.service;

import com.trilogyed.taskerservice.dao.TaskerDao;
import com.trilogyed.taskerservice.fiegn.AdserverFeignClient;
import com.trilogyed.taskerservice.model.Task;
import com.trilogyed.taskerservice.model.TaskViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TaskerServiceTest {

    @Autowired
    TaskerService taskerService;

    @Mock
    TaskerDao taskerDao;

    @Mock
    AdserverFeignClient adserverFeignClient;

    @Before
    public void setUp() {
        setUpTaskMocks();
        taskerService = new TaskerService(taskerDao, adserverFeignClient);
    }

    @Test
    public void shouldReturnTaskViewModelFromService() throws Exception {
        Task task = new Task();
        task.setId(5);
        task.setCategory("Category");
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 1, 1));
        task.setDueDate(LocalDate.of(2019, 2, 1));

        TaskViewModel taskViewModel = taskerService.buildTaskViewModel(task, "test ad");
        List<TaskViewModel> taskViewModelList = new ArrayList<>();
        taskViewModelList.add(taskViewModel);

        System.out.println(taskViewModelList.toString());
        assertEquals(taskerService.fetchTask(5).toString(), taskViewModel.toString());

    }

    public void setUpTaskMocks() {
        Task task = new Task();
        task.setId(5);
        task.setCategory("Category");
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 1, 1));
        task.setDueDate(LocalDate.of(2019, 2, 1));

        Task taskWithoutId = new Task();
        task.setCategory("Category");
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 1, 1));
        task.setDueDate(LocalDate.of(2019, 2, 1));

        List<TaskViewModel> taskList = new ArrayList<>();
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(5);
        taskViewModel.setAdvertisement("test ad");
        taskViewModel.setCategory("Category");
        taskViewModel.setDescription("Description");
        taskViewModel.setCreateDate(LocalDate.of(2019, 1, 1));
        taskViewModel.setDueDate(LocalDate.of(2019, 2, 1));
        taskList.add(taskViewModel);

        doReturn("test ad").when(adserverFeignClient).getAdFromService();
        doReturn(task).when(taskerDao).getTask(5);
        doReturn(taskList).when(taskerDao).getTasksByCategory("Category");
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(task).when(taskerDao).createTask(taskWithoutId);
    }
}
