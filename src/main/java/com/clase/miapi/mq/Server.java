package com.clase.miapi.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;

/**
 * Created by edwin on May, 2019
 */
public class Server {
    private final String url = "ssl://b-dc9b88a7-ea13-493f-a786-0951b6f4e2d9-1.mq.us-east-1.amazonaws.com:61617";
    private final String username = "user";
    private final String password = "password";

    private final ActiveMQConnectionFactory connectionFactory;
    private final PooledConnectionFactory pooledConnectionFactory;

    public static Server instance = new Server();

    private Server(){
        // Create a connection factory.
        connectionFactory = new ActiveMQConnectionFactory(url);
        // Pass the username and password.
        connectionFactory.setUserName(username);
        connectionFactory.setPassword(password);

        pooledConnectionFactory = new PooledConnectionFactory();
        pooledConnectionFactory.setConnectionFactory(connectionFactory);
        pooledConnectionFactory.setMaxConnections(10);
    }

    public Connection startConnection(){
        Connection connection = null;
        try {
// Establish a connection.
            connection = connectionFactory.createConnection();
            connection.start();
        }catch (JMSException e){
            e.printStackTrace();
        }
        return connection;
    }

    public Connection startPooledConnection(){
        Connection connection = null;
        try {
// Establish a connection.
            connection = pooledConnectionFactory.createConnection();
            connection.start();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closePool(){
        pooledConnectionFactory.stop();
    }
}