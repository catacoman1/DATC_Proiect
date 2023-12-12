package com.citydangeralert.demo.Services;


import com.citydangeralert.demo.Entities.Task;
import com.citydangeralert.demo.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task)
    {
        return taskRepository.save(task);
    }
    public Task getTaskById(String id) {

        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()) {
            return task.get();
        } else {

            return null;
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
