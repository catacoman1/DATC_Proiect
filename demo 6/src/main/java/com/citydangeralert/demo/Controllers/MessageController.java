package com.citydangeralert.demo.Controllers;

import com.citydangeralert.demo.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private static final String QUEUE_NAME = "myqueue";

    private final JmsTemplate jmsTemplate;

    @Autowired
    public MessageController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend(QUEUE_NAME, message);

        return ResponseEntity.ok("Message sent to queue: " + message);

    }

    @Scheduled(fixedRate = 540000)
    public void sendHeartbeat() {
        jmsTemplate.convertAndSend(QUEUE_NAME, "");

    }

}