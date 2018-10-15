package com.wkb.robot.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @ClassName TaskLevel1Listener
 * @Description TODO
 * @Author yilu
 * @Date 2018/10/10 16:14
 **/
public class TaskLevel1Listener implements MessageListener {
    @Override
    public void onMessage(Message message) {

    }
}
