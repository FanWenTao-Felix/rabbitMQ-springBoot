package com.felix.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by felix on 2017/7/9.
 *
 *
 */
@Component
public class Fanout {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendFount(String msg) {
        this.rabbitTemplate.convertAndSend("fanoutExchange","",msg);

    }
}
