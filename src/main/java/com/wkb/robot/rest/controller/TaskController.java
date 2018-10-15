package com.wkb.robot.rest.controller;

import com.alibaba.fastjson.JSONObject;
import com.wkb.robot.bean.QueueConfig;
import com.wkb.robot.bean.RobotTask;
import com.wkb.robot.bean.TaskConfig;
import com.wkb.robot.bean.TaskType;
import com.wkb.robot.example.QueueConfigExample;
import com.wkb.robot.example.TaskConfigExample;
import com.wkb.robot.mapper.QueueConfigMapper;
import com.wkb.robot.mapper.RobotTaskMapper;
import com.wkb.robot.mapper.TaskConfigMapper;
import com.wkb.robot.rabbitmq.service.MQTaskService;
import com.wkb.robot.rabbitmq.service.impl.MQTaskServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 对外提供的接口服务  任务调用的统一访问接口
 */
@RestController
public class TaskController {

    private static Logger logger = LoggerFactory.getLogger(TaskController.class);
    @Resource
    QueueConfigMapper queueConfigMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Resource(name = "mqTaskService")
    private MQTaskService mqTaskService;



    @RequestMapping(method = RequestMethod.POST, value = "/interface/{key}")
    public Object interfaceCore(@PathVariable("key") String key, @RequestBody JSONObject object) {
        return exeInterfaceTask(key,object);

    }

    public Object exeInterfaceTask(String key ,JSONObject object){
       JSONObject result  = new JSONObject();



       saveTask(object);
       result.put("taskNo",object.getString("taskNo"));
       result.put("result","true");
        result.put("taskType", object.getString("taskType"));

       return result;

    }

    public  void saveTask(JSONObject object) {
        RobotTask robotTask = new RobotTask();
        robotTask.setComId(object.getString("prvId"));
        robotTask.setOrgId(object.getString("areaCode"));
        String callBack = object.getString("callback");
        robotTask.setTaskSource(callBack);
        object.put("callback","http://localhost:8080/callBack/key");
        robotTask.setCreateTime(new Date());
        robotTask.setTaskInfo(object.toJSONString());
        robotTask.setTaskStatus(0);
        robotTask.setTaskNo(object.getString("taskNo"));
        String taskType = object.getString("taskType");
        robotTask.setTaskType(taskType);


        String comId = object.getString("prvId");
        String userName = object.getJSONObject("config").getString("username");
        QueueConfigExample queueConfigExample = new QueueConfigExample();
        queueConfigExample.createCriteria().andComIdEqualTo(comId).andUserNameEqualTo(userName).andTaskTypeEqualTo(taskType);
        List<QueueConfig> queueConfigList = queueConfigMapper.selectByExample(queueConfigExample);
        int queueLevel  = 0 ;
        if(queueConfigList.size()>0){
            QueueConfig queueConfig = queueConfigList.get(0);
             queueLevel = queueConfig.getQueueLevel();
            robotTask.setQueueLevel(queueLevel);
        }



//        mqTaskService.pullTaskToQueue("mq_task_queue",object);


        robotTask.setUserName(object.getJSONObject("config").getString("username"));
        switch (taskType) {
            case TaskType.QUOTE : case  TaskType.INSURE :case TaskType.CONTINUEINSURE:{
                    robotTask.setLicenseNo(object.getString("carNo"));
                    robotTask.setFrameNo(object.getString("vinCode"));
                    robotTask.setEngineNo(object.getString("engineNo"));
            }
            case TaskType.CARTYPEQUERY:{
                if(object.containsKey("vinCode")){
                    robotTask.setFrameNo(object.getString("vinCode"));
                }else{
                    robotTask.setVehicleName(object.getString("vehicleName"));
                }
            }
            case TaskType.CARINFOQUERY:{
                robotTask.setLicenseNo(object.getString("carNo"));
            }
            case TaskType.QUOTEQUERY: case TaskType.INSUREQUERY: case TaskType.APPROVEDQUERY: case TaskType.PAY: case TaskType.SUBMITPIN: case TaskType.INPUTPIN:
            case  TaskType.PERSONINFOCONFIRM:case TaskType.GETELECTRICPOLICYPDF:{
                if(object.containsKey("bizInsurePolicyNo")){
                    robotTask.setBizPolicyNo(object.getString("bizInsurePolicyNo"));
                }
                if(object.containsKey("efcInsurePolicy")){
                    robotTask.setEfcPolicyNo(object.getString("efcInsurePolicy"));
                }
                if(object.containsKey("bizInsureUnderwriting")){
                    robotTask.setBizInsureUnderwriting(object.getString("bizInsureUnderwriting"));
                }
                if(object.containsKey("efcInsureUnderwriting")){
                    robotTask.setEfcInsureUnderwriting(object.getString("efcInsureUnderwriting"));
                }
            }
            case TaskType.CONTINUEINFOQUERY:{
                robotTask.setLicenseNo(object.getString("carNo"));
                if(object.containsKey("vinCode")){
                    robotTask.setFrameNo(object.getString("vinCode"));
                }
                if(object.containsKey("bizInsurePolicyNo")){
                    robotTask.setBizPolicyNo(object.getString("bizInsurePolicyNo"));
                }
                if(object.containsKey("efcInsurePolicy")){
                    robotTask.setEfcPolicyNo(object.getString("efcInsurePolicy"));
                }
            }
        }

        String queueName = "";
        if(queueLevel>2){
            robotTask.setTaskProcess("db");
            queueName = "db_task_queue";
        }else if(queueLevel == 0 ){

        }else{
            robotTask.setTaskProcess("mq");
            queueName = "mq_task_queue";
        }
        mqTaskService.pullTaskToQueue(queueName,robotTask);
    }
}


