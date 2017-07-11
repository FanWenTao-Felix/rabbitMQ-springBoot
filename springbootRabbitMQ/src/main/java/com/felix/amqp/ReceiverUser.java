package com.felix.amqp;

import com.felix.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by felix on 2017/7/10.
 */
@Component
public class ReceiverUser {
    @RabbitListener(queues = "com.felix.user",containerFactory="rabbitListenerContainerFactory")
    public void process(User user) {
        System.out.println("Receiver  : " + user.getName());
    }


}