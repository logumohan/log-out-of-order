package com.test.log4j2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

public class Log4J2Test {

	public static void main(String[] args) {
		BasicThreadFactory factory = new BasicThreadFactory.Builder().namingPattern("workerthread-%d").daemon(true)
				.priority(Thread.MAX_PRIORITY).build();

		ExecutorService service = Executors.newFixedThreadPool(50, factory);
		for (int i = 0; i < 50; i++) {
			service.submit(new LoggerThread());
		}
		try {
			service.awaitTermination(1000, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
