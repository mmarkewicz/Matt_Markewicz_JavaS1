package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() {
        List<Task> taskList = taskerDao.getAllTasks();
        taskList.stream()
                .forEach(task -> taskerDao.deleteTask(task.getId()));
    }

    @After
    public void tearDown() {
        List<Task> taskList = taskerDao.getAllTasks();
        taskList.stream()
                .forEach(task -> taskerDao.deleteTask(task.getId()));
    }

    @Test
    public void addGetDeleteTask() {
        LocalDate createDate = LocalDate.of(2019, 1, 1);
        LocalDate dueDate = LocalDate.of(2019, 2, 1);
        Task task = new Task();
        task.setCategory("Category");
        task.setDescription("Description");
        task.setCreateDate(createDate);
        task.setDueDate(dueDate);
        task.setId(taskerDao.createTask(task).getId());

        Task taskFromDb = taskerDao.getTask(task.getId());

        assertEquals(task, taskFromDb); // assert that add and get are working

        taskerDao.deleteTask(task.getId());

        assertEquals(taskerDao.getAllTasks().size(), 0);
    }

    @Test
    public void updateTask() {
        LocalDate createDate = LocalDate.of(2019, 1, 1);
        LocalDate dueDate = LocalDate.of(2019, 2, 1);
        Task task = new Task();
        task.setCategory("Category");
        task.setDescription("Description");
        task.setCreateDate(createDate);
        task.setDueDate(dueDate);
        task.setId(taskerDao.createTask(task).getId());

        task.setCategory("New Category");
        taskerDao.updateTask(task);

        assertEquals(taskerDao.getTask(task.getId()).getCategory(), "New Category");
    }

    @Test
    public void getAllTasks() {
        LocalDate createDate = LocalDate.of(2019, 1, 1);
        LocalDate dueDate = LocalDate.of(2019, 2, 1);
        Task task = new Task();
        task.setCategory("Category");
        task.setDescription("Description");
        task.setCreateDate(createDate);
        task.setDueDate(dueDate);
        task.setId(taskerDao.createTask(task).getId());

        assertEquals(taskerDao.getAllTasks().size(), 1);
    }

    @Test
    public void getTaskByCategory() {
        LocalDate createDate = LocalDate.of(2019, 1, 1);
        LocalDate dueDate = LocalDate.of(2019, 2, 1);
        Task task = new Task();
        task.setCategory("Category");
        task.setDescription("Description");
        task.setCreateDate(createDate);
        task.setDueDate(dueDate);
        task.setId(taskerDao.createTask(task).getId());

        assertEquals(taskerDao.getTasksByCategory("Category").size(), 1);
        assertEquals(taskerDao.getTasksByCategory("None").size(), 0);
    }
}
