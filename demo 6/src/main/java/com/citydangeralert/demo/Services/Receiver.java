package com.citydangeralert.demo.Services;

import com.citydangeralert.demo.Entities.Task;
import com.citydangeralert.demo.Repositories.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Receiver {


    @Autowired
    private TaskRepository taskRepository;

    @JmsListener(destination = "myqueue")
    public void receiveMessage(String messageJson){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Task task = objectMapper.readValue(messageJson, Task.class);
            taskRepository.save(task);
            System.out.println("Received and saved task: " + task);
        } catch (Exception e) {
            System.out.println("Error processing message: " + e.getMessage());
        }
    }

}