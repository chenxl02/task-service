package com.wkb.robot.bean;

import java.io.Serializable;

public class QueueConfig implements Serializable {
    /**  */
    private Integer id;

    /** 队列Id */
    private Integer queueLevel;

    /** 任务类型 */
    private String taskType;

    /** 保险公司id */
    private String comId;

    /** 用户名 */
    private String userName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQueueLevel() {
        return queueLevel;
    }

    public void setQueueLevel(Integer queueLevel) {
        this.queueLevel = queueLevel;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", queueLevel=").append(queueLevel);
        sb.append(", taskType=").append(taskType);
        sb.append(", comId=").append(comId);
        sb.append(", userName=").append(userName);
        sb.append("]");
        return sb.toString();
    }
}