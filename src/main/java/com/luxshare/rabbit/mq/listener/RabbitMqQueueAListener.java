package com.luxshare.rabbit.mq.listener;

import com.alibaba.fastjson.JSON;
import com.luxshare.rabbit.mq.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * rabbit mq 消费端
 *
 * @author lion hua
 * @since 2019-11-20
 */
@Component
@RabbitListener(queues = "queueA")
@Slf4j
public class RabbitMqQueueAListener {

    @RabbitHandler
    public void receive(Person person) {
        log.info(JSON.toJSONString(person, true));
    }
}
