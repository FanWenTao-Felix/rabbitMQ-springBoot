package com.felix.amqp;

import com.felix.domain.User;
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
		return new Queue("com.felix",true);
	}


	public void sendUser(User user) {
		this.rabbitTemplate.convertAndSend("com.felix.user",user);

	}

	//ACK=false, exchange不存在
//	public void send(String msg) {
//		this.rabbitTemplate.convertAndSend("123","com.felix",msg);
//
//	}
	//ACK=false, routingKey不存在
//	public void send(String msg) {
//		this.rabbitTemplate.convertAndSend("123","com.noFelix",msg);
//
//	}
	public void send(String msg) {
		this.rabbitTemplate.convertAndSend("com.felix",msg);

	}
}
