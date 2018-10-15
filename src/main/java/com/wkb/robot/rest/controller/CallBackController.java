package com.wkb.robot.rest.controller;

import com.alibaba.fastjson.JSONObject;
import com.wkb.robot.bean.RobotTask;
import com.wkb.robot.example.RobotTaskExample;
import com.wkb.robot.mapper.RobotTaskMapper;
import com.wkb.robot.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CallBackController
 * @Description 精灵回调接口   如果压力大 考虑也用队列消费 存储 然后回调carservice
 * @Author yilu
 * @Date 2018/10/11 16:21
 **/
@RestController
public class CallBackController {
    @Resource
    RobotTaskMapper robotTaskMapper;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "/callBack/{key}")
    public Object interfaceCore(@PathVariable("key") String key, @RequestBody JSONObject object) {
         String taskType = object.getString("taskType");
         String taskNo = object.getString("taskNo");
        RobotTaskExample robotTaskExample = new RobotTaskExample();
        robotTaskExample.createCriteria().andTaskTypeEqualTo(taskType).andTaskNoEqualTo(taskNo);
        List<RobotTask> robotTaskList = robotTaskMapper.selectByExample(robotTaskExample);
        if(robotTaskList.size()>0){
            RobotTask robotTask  = robotTaskList.get(0);
            String errorCode = object.getString("errorCode");
            if("999".equals(errorCode)){
                robotTask.setTaskStatus(2);

            }else{
                robotTask.setTaskStatus(3);
                robotTask.setErrorInfo(object.getString("errorMessage"));
            }
            if(object.containsKey("platformInfo")){
                robotTask.setPlatInfo((object.getJSONObject("platformInfo").toJSONString()));
            }
            robotTask.setResultInfo(object.toJSONString());

            String comId = robotTask.getComId();
            String userName= robotTask.getUserName();

            String redisKey = "mq_"+comId+userName;
            if(redisTemplate.hasKey(redisKey)){
                int currentTaskSize = 0 ;
                if(redisTemplate.hasKey(redisKey)){
                    currentTaskSize = Integer.parseInt(redisTemplate.opsForValue().get(redisKey));
                }else{
                    redisTemplate.opsForValue().set(redisKey,currentTaskSize+"");
                }
                currentTaskSize--;
                redisTemplate.opsForValue().set(redisKey,currentTaskSize+"");
            }else{
                //todo警告 redis中没有对应的key
            }
            if("mq".equals(robotTask.getTaskProcess())){

            }else if("db".equals(robotTask.getTaskProcess())){
                //TODO 减少db对应的阀值。
            }else{

            }


            try {
                HttpClientUtil.callBack("post",robotTask.getTaskSource(),object);
            } catch (Exception e) {
                e.printStackTrace();
            }
            robotTaskMapper.updateByPrimaryKey(robotTask);
        }else{

        }

        JSONObject result  = new JSONObject();


        result.put("taskNo",object.getString("taskNo"));
        result.put("result","true");
        result.put("taskType", object.getString("taskType"));

        return result;



    }
}
