package com.felix.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
/**
 * Created by felix on 2017/7/9.
 */
@Component
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue felixQueue() {
		return new Queue("com.felix");
	}
	public void send(String msg) {
		this.rabbitTemplate.convertAndSend("com.felix",msg);

	}

}
