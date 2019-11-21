package com.luxshare.rabbit.mq;

import com.luxshare.rabbit.mq.pojo.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送消息
 *
 * @author lion hua
 * @since 2019-11-20
 */
@Component
@Slf4j
public class SendMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 实质上,rabbit mq 都是通过 exchange(direct) 路径绑定至 队列
     */
    public void sendMessageToQueueA() {
        rabbitTemplate.convertAndSend("queueA", new Person("xx", 22));
    }

    public void sendMessageTopicExchange() {
        rabbitTemplate.convertAndSend("topicExchange","topic.a.b",new Person("topic.#", 22));
    }

    public void sendMessageFanoutExchange() {
        rabbitTemplate.convertAndSend("fanoutExchange","",new Person("fanout",33));
    }
}
