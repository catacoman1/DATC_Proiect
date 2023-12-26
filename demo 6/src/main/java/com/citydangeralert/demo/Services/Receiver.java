package com.citydangeralert.demo.Services;

import com.microsoft.azure.servicebus.*;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class Receiver {
    private static final String CONNECTION_STRING = "Endpoint=sb://citydangers.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=8v90gwAN/P0i7qS2yIShJ++2AncySr85v+ASbB4gaZ4=";
    private static final String QUEUE_NAME = "myqueue";
    private IQueueClient queueClient;

    public Receiver() {
        try {
            this.queueClient = new QueueClient(new ConnectionStringBuilder(CONNECTION_STRING, QUEUE_NAME), ReceiveMode.PEEKLOCK);
            this.registerMessageHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerMessageHandler() {
        try {
            this.queueClient.registerMessageHandler(new IMessageHandler() {
                @Override
                public CompletableFuture<Void> onMessageAsync(IMessage message) {
                    // Check if the message body is null
                    if (message.getBody() == null) {
                        System.out.println("Received a message with null body");
                        return CompletableFuture.completedFuture(null);
                    }

                    // Convert the message body to a string
                    byte[] body = message.getBody();
                    String messageString = new String(body);
                    System.out.println("Received message: " + messageString);

                    // Additional logging for debugging
                    System.out.println("Message ID: " + message.getMessageId());
                    System.out.println("Message Properties: " + message.getProperties());

                    // Process the message here

                    return queueClient.completeAsync(message.getLockToken());
                }

                @Override
                public void notifyException(Throwable exception, ExceptionPhase phase) {
                    System.out.printf("Exception: %s, Phase: %s\n", exception.getMessage(), phase);
                }
            });
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ServiceBusException e) {
            throw new RuntimeException(e);
        }
    }
}
