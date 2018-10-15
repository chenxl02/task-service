package com.wkb.robot.rabbitmq.listener;

import com.alibaba.fastjson.JSONObject;
import com.wkb.robot.bean.RobotTask;
import com.wkb.robot.bean.TaskConfig;
import com.wkb.robot.example.TaskConfigExample;
import com.wkb.robot.mapper.QueueConfigMapper;
import com.wkb.robot.mapper.RobotTaskMapper;
import com.wkb.robot.mapper.TaskConfigMapper;
import com.wkb.robot.util.HttpClientUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MQTaskListener
 * @Description TODO
 * @Author yilu
 * @Date 2018/10/11 13:38
 **/
public class MQTaskListener implements MessageListener {

    @Resource
    RobotTaskMapper robotTaskMapper;

    protected MessageConverter messageConverter;

    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Resource
    TaskConfigMapper taskConfigMapper;

    @Transactional
    @Override
    public void onMessage(Message message) {
        RobotTask robotTask = null ;
        try {
            robotTask = (RobotTask) messageConverter.fromMessage(message);
            String comId = robotTask.getComId();
            String userName = robotTask.getUserName();
            String redisKey = "mq_"+comId+userName;
            String sizeKey  = "max_size_"+comId+userName;
            int currentTaskSize = 0 ;
            int maxSize = 0;
            if(redisTemplate.hasKey(redisKey)){
                 currentTaskSize = Integer.parseInt(redisTemplate.opsForValue().get(redisKey));
            }else{
                redisTemplate.opsForValue().set(redisKey,currentTaskSize+"");
            }

            if(redisTemplate.hasKey(sizeKey)){
                maxSize = Integer.parseInt(redisTemplate.opsForValue().get(sizeKey));
            }else{
                TaskConfigExample taskConfigExample = new TaskConfigExample();
                taskConfigExample.createCriteria().andComIdEqualTo(comId).andUserNameEqualTo(userName);
                List<TaskConfig> taskConfigList = taskConfigMapper.selectByExample(taskConfigExample);
                if(taskConfigList.size()>0){
                    TaskConfig taskConfig = taskConfigList.get(0);
                    maxSize = taskConfig.getMaxSize();
                    redisTemplate.opsForValue().set(sizeKey,maxSize+"");
                }else{

                }
            }

            if(currentTaskSize<maxSize){
                HttpClientUtil.callBack("post","http://123.56.76.71:8081/interface/carFlow",JSONObject.parseObject(robotTask.getTaskInfo()));
                robotTask.setTaskProcess("mq");
                robotTask.setTaskStatus(1);
                currentTaskSize++;
                redisTemplate.opsForValue().set(redisKey,currentTaskSize+"");
            }else{
                robotTask.setTaskProcess("db");

            }
            robotTaskMapper.insert(robotTask);

        } catch (Exception e) {

        }
    }
}
