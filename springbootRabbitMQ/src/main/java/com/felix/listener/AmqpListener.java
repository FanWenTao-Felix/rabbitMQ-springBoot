package com.felix.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by felix on 2017/7/10.
 */
@Component
public class AmqpListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message,Channel channel) {
        byte[] body = message.getBody();
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
            System.out.println("receive msg : " + new String(body));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
