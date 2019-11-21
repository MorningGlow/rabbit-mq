package com.luxshare.rabbit.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbit mq configuration
 *
 * @author lion hua
 * @since 2019-11-20
 */
@Configuration
public class RabbitMqConfiguration {

    @Bean
    public Queue queueA() {
        return new Queue("queueA");
    }

    @Bean
    public Queue queueB() {
        return new Queue("queueB");
    }

    @Bean
    public Queue queueC() {
        return new Queue("queueC");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingExchangeWithRoutingKey(Queue queueA,TopicExchange topicExchange) {
        return BindingBuilder.bind(queueA).to(topicExchange).with("topic.a");
    }

    @Bean
    public Binding bindingExchangeWithRoutingKeys(Queue queueB,TopicExchange topicExchange) {
        return BindingBuilder.bind(queueB).to(topicExchange).with("topic.#");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingFanoutExchangeWithQueueA(Queue queueA , FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutExchangeWithQueueB(Queue queueB , FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueB).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutExchangeWithQueueC(Queue queueC , FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueC).to(fanoutExchange);
    }

}
