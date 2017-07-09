package com.felix.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by felix on 2017/7/9.
 *
 * 监听com.felix队列
 */

@Component
@RabbitListener(queues = "com.felix")
public class Receiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver  : " + msg);
    }


}