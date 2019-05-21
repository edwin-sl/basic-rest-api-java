package com.clase.miapi.mq;

import javax.jms.*;

/**
 * Created by edwin on May, 2019
 */
public class Producer {
    public Producer(){
        try {
// Establish a connection for the producer.
            final Connection producerConnection = Server.instance.startPooledConnection();

        // Create a session.
        final Session producerSession = producerConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

// Create a queue named "MyQueue".
        final Destination producerDestination = producerSession.createQueue("MyQueue");

// Create a producer from the session to the queue.
        final MessageProducer producer = producerSession.createProducer(producerDestination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a message.
            final String text = "Hello from Amazon MQ!";
            TextMessage producerMessage = producerSession.createTextMessage(text);

// Send the message.
            producer.send(producerMessage);
            System.out.println("Message sent.");

            producer.close();
            producerSession.close();
            producerConnection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
