package com.wkb.robot.rabbitmq.service;

public interface MQTaskService {
	/**
	 * 发送消息到指定队列
	 * 
	 * @param queueKey 路由键
	 * @param object 消息
	 */
	public void pullTaskToQueue(String queueKey, Object object);
}
