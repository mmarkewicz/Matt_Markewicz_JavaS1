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

import java.lang.reflect.Array;
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

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        TaskViewModel taskViewModel = taskerService.buildTaskViewModel(task, "test ad");

        assertEquals(taskViewModel.toString(), taskerService.fetchTask(5).toString());
//        assertEquals(taskViewModel.toString(), taskerService.fetchTasksByCategory("Category").get(0).toString());
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

//        List<TaskViewModel> taskList = new ArrayList<>();
//        TaskViewModel taskViewModel = taskerService.buildTaskViewModel(task, "test ad");
//        taskList.add(taskViewModel);

        doReturn(task).when(taskerDao).getTask(5);
//        doReturn(taskList).when(taskerDao).getTasksByCategory("Category");
//        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(task).when(taskerDao).createTask(taskWithoutId);
        doReturn("test ad").when(adserverFeignClient).getAdFromService();
    }
}
