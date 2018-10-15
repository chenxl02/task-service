package com.wkb.robot.mapper;

import com.wkb.robot.bean.QueueConfig;
import com.wkb.robot.example.QueueConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QueueConfigMapper extends BaseMapper{
    int countByExample(QueueConfigExample example);

    int deleteByExample(QueueConfigExample example);

    int insert(QueueConfig record);

    int insertSelective(QueueConfig record);

    List<QueueConfig> selectByExample(QueueConfigExample example);

    int updateByExampleSelective(@Param("record") QueueConfig record, @Param("example") QueueConfigExample example);

    int updateByExample(@Param("record") QueueConfig record, @Param("example") QueueConfigExample example);
}