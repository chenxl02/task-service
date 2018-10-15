package com.wkb.robot.mapper;

import com.wkb.robot.bean.RobotQueue;
import com.wkb.robot.example.RobotQueueExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RobotQueueMapper  extends BaseMapper {
    int countByExample(RobotQueueExample example);

    int deleteByExample(RobotQueueExample example);

    int insert(RobotQueue record);

    int insertSelective(RobotQueue record);

    List<RobotQueue> selectByExample(RobotQueueExample example);

    int updateByExampleSelective(@Param("record") RobotQueue record, @Param("example") RobotQueueExample example);

    int updateByExample(@Param("record") RobotQueue record, @Param("example") RobotQueueExample example);
}