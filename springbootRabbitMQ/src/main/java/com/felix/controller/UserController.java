package com.felix.controller;

import com.felix.amqp.Fanout;
import com.felix.amqp.SendTopic;
import com.felix.amqp.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by felix on 2017/7/8.
 */
@RestController
public class UserController {

    @Autowired
    private Sender sender;

    @Autowired
    private SendTopic sendTopic;

    @Autowired
    private Fanout fanout;
    @GetMapping(value = "/send")
    public String send(String msg) {
        sender.send(msg);
        return "Send OK.";
    }

    @GetMapping(value = "/sendTopic")
    public String sendTopic(String msg) {
        sendTopic.sendTopic(msg);
        return "Send OK.";
    }
    @GetMapping(value = "/sendLike")
    public String sendLike(String msg) {
        sendTopic.sendLike(msg);
        return "Send OK.";
    }
    @GetMapping(value = "/sendFount")
    public String sendFount(String msg) {
        sendTopic.sendLike(msg);
        return "Send OK.";
    }
    @GetMapping(value = "/fanout")
    public String fanout(String msg) {
        fanout.sendFount(msg);
        return "Send OK.";
    }
}
