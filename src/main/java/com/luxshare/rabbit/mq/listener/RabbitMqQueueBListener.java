package com.luxshare.rabbit.mq.listener;

import com.alibaba.fastjson.JSON;
import com.luxshare.rabbit.mq.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * queueB 队列
 *
 * @author lion hua
 * @since 2019-11-21
 */
@Component
@RabbitListener(queues = {"queueB"})
@Slf4j
public class RabbitMqQueueBListener {
    @RabbitHandler
    public void handler(Person person) {
        log.info("这是队列B");
        log.info(JSON.toJSONString(person, true));
    }
}
