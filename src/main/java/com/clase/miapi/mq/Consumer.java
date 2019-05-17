package com.clase.miapi.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by edwin on May, 2019
 */
public class Consumer {
    public Consumer(){
        try {
// Establish a connection for the consumer.
        final Connection consumerConnection = Server.instance.startConnection();

        // Create a session.
        final Session consumerSession = consumerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

// Create a queue named "MyQueue".
        final Destination consumerDestination = consumerSession.createQueue("MyQueue");

// Create a message consumer from the session to the queue.
        final MessageConsumer consumer = consumerSession.createConsumer(consumerDestination);

// Begin to wait for messages.
            consumer.setMessageListener(message -> {
                final TextMessage consumerTextMessage = (TextMessage) message;
                try {
                    System.out.println("Listener received: " + consumerTextMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            });
//        final Message consumerMessage = consumer.receive(1000);
//
//// Receive the message when it arrives.
//        final TextMessage consumerTextMessage = (TextMessage) consumerMessage;
//        System.out.println("Message received: " + consumerTextMessage.getText());

//        consumer.close();
//        consumerSession.close();

//        consumerConnection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
