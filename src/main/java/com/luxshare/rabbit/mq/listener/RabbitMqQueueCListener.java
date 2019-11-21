package com.luxshare.rabbit.mq.listener;

import com.alibaba.fastjson.JSON;
import com.luxshare.rabbit.mq.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * queue c 队列监听
 *
 * @author lion hua
 * @since 2019-11-21
 */
@Slf4j
@Component
@RabbitListener(queues = {"queueC"})
public class RabbitMqQueueCListener {

    @RabbitHandler
    public void handler(Person person) {
        log.info("这是队列C:{}", JSON.toJSONString(person, true));
    }
}
