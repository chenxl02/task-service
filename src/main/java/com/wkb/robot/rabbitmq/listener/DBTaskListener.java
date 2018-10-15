package com.wkb.robot.rabbitmq.listener;

import com.wkb.robot.bean.RobotTask;
import com.wkb.robot.mapper.RobotTaskMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;

import javax.annotation.Resource;

/**
 * @ClassName DBTaskListener
 * @Description TODO
 * @Author yilu
 * @Date 2018/10/11 13:37
 **/
public class DBTaskListener implements MessageListener {
    @Resource
    RobotTaskMapper robotTaskMapper;

    protected MessageConverter messageConverter;

    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    @Override
    public void onMessage(Message message) {
        RobotTask robotTask = null ;
        try {
            robotTask = (RobotTask) messageConverter.fromMessage(message);
            robotTask.setTaskProcess("db");

            robotTaskMapper.insert(robotTask);
        } catch (Exception e) {

        }

    }



}
