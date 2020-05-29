package com.test.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LoggerThread implements Runnable {

	private static final Logger logger = LogManager.getLogger("example");

	@Override
	public void run() {
		for (;;) {
			ThreadContext.put("user", Thread.currentThread().getName());
			ThreadContext.put("code", "CODE-1");
			ThreadContext.put("resolution", "RESOLUTION-1");

			logger.info("Logging from thread {}", Thread.currentThread().getName());
		}
	}

}
