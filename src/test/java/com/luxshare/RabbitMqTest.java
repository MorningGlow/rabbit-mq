package com.luxshare;

import com.luxshare.rabbit.mq.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RabbitMqApplication.class})
@Slf4j
public class RabbitMqTest {

    @Autowired
    private SendMessage sendMessage;

    @Test
    public void test() {
        sendMessage.sendMessageToQueueA();
    }

    @Test
    public void testTopic() {
        sendMessage.sendMessageTopicExchange();
    }

}
