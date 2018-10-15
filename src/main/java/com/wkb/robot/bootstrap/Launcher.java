package com.wkb.robot.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Launcher {
	private static Logger LOGGER = LoggerFactory.getLogger(Launcher.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LOGGER.info("启动...");
		com.alibaba.dubbo.container.Main.main(args);
	}
}
