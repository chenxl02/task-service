package com.wkb.robot.bean;

import java.io.Serializable;
import java.util.Date;

public class RobotTask implements Serializable {
    /**  */
    private Integer id;

    /** 任务号 */
    private String taskNo;

    /** 保险公司id */
    private String comId;

    /** 保险公司用户名 */
    private String userName;

    /** 机构id */
    private String orgId;

    /**  */
    private Integer queueLevel;

    /** 任务类型 */
    private String taskType;

    /** 任务处理消费方式  rabbitMq   db */
    private String taskProcess;

    /** 任务状态 */
    private Integer taskStatus;

    /** 任务调用来源 */
    private String taskSource;

    /** 任务接收方 */
    private String taskReceiver;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    /** 任务消耗时间 */
    private Long comsumingTime;

    /** 任务信息 */
    private String taskInfo;

    /** 任务结果信息 */
    private String resultInfo;

    /** 任务平台信息 */
    private String platInfo;

    /** 任务报错异常信息 */
    private String errorInfo;

    /** 车牌号 */
    private String licenseNo;

    /** 发动机号 */
    private String engineNo;

    /** 车架号 */
    private String frameNo;

    /** 车型名称 */
    private String vehicleName;

    /** 商业险保单号 */
    private String bizPolicyNo;

    /** 交强险保单号 */
    private String efcPolicyNo;

    /** 商业险投保单号 */
    private String bizInsureUnderwriting;

    /** 交强险投保单号 */
    private String efcInsureUnderwriting;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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

    public String getTaskProcess() {
        return taskProcess;
    }

    public void setTaskProcess(String taskProcess) {
        this.taskProcess = taskProcess == null ? null : taskProcess.trim();
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskSource() {
        return taskSource;
    }

    public void setTaskSource(String taskSource) {
        this.taskSource = taskSource == null ? null : taskSource.trim();
    }

    public String getTaskReceiver() {
        return taskReceiver;
    }

    public void setTaskReceiver(String taskReceiver) {
        this.taskReceiver = taskReceiver == null ? null : taskReceiver.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getComsumingTime() {
        return comsumingTime;
    }

    public void setComsumingTime(Long comsumingTime) {
        this.comsumingTime = comsumingTime;
    }

    public String getTaskInfo() {
        return taskInfo;
    }

    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo == null ? null : taskInfo.trim();
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo == null ? null : resultInfo.trim();
    }

    public String getPlatInfo() {
        return platInfo;
    }

    public void setPlatInfo(String platInfo) {
        this.platInfo = platInfo == null ? null : platInfo.trim();
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo == null ? null : errorInfo.trim();
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo == null ? null : engineNo.trim();
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo == null ? null : frameNo.trim();
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName == null ? null : vehicleName.trim();
    }

    public String getBizPolicyNo() {
        return bizPolicyNo;
    }

    public void setBizPolicyNo(String bizPolicyNo) {
        this.bizPolicyNo = bizPolicyNo == null ? null : bizPolicyNo.trim();
    }

    public String getEfcPolicyNo() {
        return efcPolicyNo;
    }

    public void setEfcPolicyNo(String efcPolicyNo) {
        this.efcPolicyNo = efcPolicyNo == null ? null : efcPolicyNo.trim();
    }

    public String getBizInsureUnderwriting() {
        return bizInsureUnderwriting;
    }

    public void setBizInsureUnderwriting(String bizInsureUnderwriting) {
        this.bizInsureUnderwriting = bizInsureUnderwriting == null ? null : bizInsureUnderwriting.trim();
    }

    public String getEfcInsureUnderwriting() {
        return efcInsureUnderwriting;
    }

    public void setEfcInsureUnderwriting(String efcInsureUnderwriting) {
        this.efcInsureUnderwriting = efcInsureUnderwriting == null ? null : efcInsureUnderwriting.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskNo=").append(taskNo);
        sb.append(", comId=").append(comId);
        sb.append(", userName=").append(userName);
        sb.append(", orgId=").append(orgId);
        sb.append(", queueLevel=").append(queueLevel);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskProcess=").append(taskProcess);
        sb.append(", taskStatus=").append(taskStatus);
        sb.append(", taskSource=").append(taskSource);
        sb.append(", taskReceiver=").append(taskReceiver);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", comsumingTime=").append(comsumingTime);
        sb.append(", taskInfo=").append(taskInfo);
        sb.append(", resultInfo=").append(resultInfo);
        sb.append(", platInfo=").append(platInfo);
        sb.append(", errorInfo=").append(errorInfo);
        sb.append(", licenseNo=").append(licenseNo);
        sb.append(", engineNo=").append(engineNo);
        sb.append(", frameNo=").append(frameNo);
        sb.append(", vehicleName=").append(vehicleName);
        sb.append(", bizPolicyNo=").append(bizPolicyNo);
        sb.append(", efcPolicyNo=").append(efcPolicyNo);
        sb.append(", bizInsureUnderwriting=").append(bizInsureUnderwriting);
        sb.append(", efcInsureUnderwriting=").append(efcInsureUnderwriting);
        sb.append("]");
        return sb.toString();
    }
}