package com.wkb.robot.rabbitmq.service.impl;

import com.wkb.robot.rabbitmq.service.MQTaskService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName MQTaskServiceImpl
 * @Description TODO
 * @Author yilu
 * @Date 2018/10/10 16:45
 **/
@Service("mqTaskService")
public class MQTaskServiceImpl implements MQTaskService {

    @Autowired
    private AmqpTemplate amqpTemplate;


    @Override
    public void pullTaskToQueue(String queueKey, Object object) {
        amqpTemplate.convertAndSend(queueKey,object);
    }
}
