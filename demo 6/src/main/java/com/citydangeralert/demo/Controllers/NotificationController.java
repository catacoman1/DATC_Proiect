package com.citydangeralert.demo.Controllers;

import com.citydangeralert.demo.Entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/task")
    @SendTo("/topic/tasks")
    public Task send(final Task message) throws Exception {
        return message;

    }
}
