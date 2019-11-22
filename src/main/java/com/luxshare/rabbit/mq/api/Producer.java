package com.luxshare.rabbit.mq.api;

import com.alibaba.fastjson.JSON;
import com.luxshare.rabbit.mq.pojo.Person;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.TimeoutException;

/**
 * 生产端 原生api写
 *
 * @author lion hua
 * @since 2019-11-21
 */
public class Producer {

    public void test() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("114.67.72.153");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("root");
        connectionFactory.setPassword("luxshare");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        Person person = new Person("api test", 22);
        final byte[] bytes = JSON.toJSONString(person).getBytes();
        // 发送
        channel.basicPublish("","queueD",null, bytes);

        // 关闭
        channel.close();
        connection.close();

    }

    public static void main(String[] args) throws IOException, TimeoutException {
        new Producer().test();
    }
}
