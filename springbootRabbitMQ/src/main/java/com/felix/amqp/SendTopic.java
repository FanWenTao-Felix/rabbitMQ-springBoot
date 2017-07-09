package com.felix.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by felix on 2017/7/9.
 *
 * topic的exchange测试用例,like的队列接受两条，message的队列只能接受一跳
 */
@Component
public class SendTopic {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTopic(String msg) {
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg);

    }

    public void sendLike(String msg) {
        this.rabbitTemplate.convertAndSend("exchange", "topic.like", msg);

    }
}
