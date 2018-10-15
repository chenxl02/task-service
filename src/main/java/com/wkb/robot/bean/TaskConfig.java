package com.wkb.robot.bean;

import java.io.Serializable;

public class TaskConfig implements Serializable {
    /**  */
    private Integer id;

    /** 保险公司id */
    private String comId;

    /** 保险公司用户名 */
    private String userName;

    /** 任务最大数量 */
    private Integer maxSize;

    /** 低优先级任务最大数量 */
    private Integer dbMaxSize;

    /** 任务最长执行时间 */
    private Integer maxTime;

    /** 超时任务最大数 */
    private Integer overTimeSize;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Integer getDbMaxSize() {
        return dbMaxSize;
    }

    public void setDbMaxSize(Integer dbMaxSize) {
        this.dbMaxSize = dbMaxSize;
    }

    public Integer getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(Integer maxTime) {
        this.maxTime = maxTime;
    }

    public Integer getOverTimeSize() {
        return overTimeSize;
    }

    public void setOverTimeSize(Integer overTimeSize) {
        this.overTimeSize = overTimeSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", comId=").append(comId);
        sb.append(", userName=").append(userName);
        sb.append(", maxSize=").append(maxSize);
        sb.append(", dbMaxSize=").append(dbMaxSize);
        sb.append(", maxTime=").append(maxTime);
        sb.append(", overTimeSize=").append(overTimeSize);
        sb.append("]");
        return sb.toString();
    }
}