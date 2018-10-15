package com.wkb.robot.mapper;

import com.wkb.robot.bean.TaskConfig;
import com.wkb.robot.example.TaskConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskConfigMapper extends BaseMapper{
    int countByExample(TaskConfigExample example);

    int deleteByExample(TaskConfigExample example);

    int insert(TaskConfig record);

    int insertSelective(TaskConfig record);

    List<TaskConfig> selectByExample(TaskConfigExample example);

    int updateByExampleSelective(@Param("record") TaskConfig record, @Param("example") TaskConfigExample example);

    int updateByExample(@Param("record") TaskConfig record, @Param("example") TaskConfigExample example);
}