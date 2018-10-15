package com.wkb.robot.mapper;

import com.wkb.robot.bean.RobotTask;
import com.wkb.robot.example.RobotTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RobotTaskMapper extends BaseMapper{
    int countByExample(RobotTaskExample example);

    int deleteByExample(RobotTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RobotTask record);

    int insertSelective(RobotTask record);

    List<RobotTask> selectByExample(RobotTaskExample example);

    RobotTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RobotTask record, @Param("example") RobotTaskExample example);

    int updateByExample(@Param("record") RobotTask record, @Param("example") RobotTaskExample example);

    int updateByPrimaryKeySelective(RobotTask record);

    int updateByPrimaryKey(RobotTask record);
}