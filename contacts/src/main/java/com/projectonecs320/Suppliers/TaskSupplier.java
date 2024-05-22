package com.projectonecs320.Suppliers;

import java.util.function.Supplier;

import com.projectonecs320.Classes.Task;
import com.projectonecs320.Services.TaskService;

public class TaskSupplier implements Supplier<Task> {

    private TaskService taskService;

    public TaskSupplier(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @Override
    public Task get() {
        return new Task(taskService.generateId());
    }
    
}
