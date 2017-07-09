package com.felix.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by felix on 2017/7/9.
 */
@Configuration
public class TopicRabbitConfig {
    final static String message = "felix.topic.message";
    final static String like = "felix.topic.like";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue like() {
        return new Queue(TopicRabbitConfig.like);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("felix.exchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue like, TopicExchange exchange) {
        return BindingBuilder.bind(like).to(exchange).with("topic.#");
    }
}
