package com.test.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.async.AsyncQueueFullPolicy;
import org.apache.logging.log4j.core.async.EventRoute;

public class BlockingQueueFullPolicy implements AsyncQueueFullPolicy {

	public BlockingQueueFullPolicy() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public EventRoute getRoute(long backgroundThreadId, Level level) {
		System.out.println("Enqueue ..");
		return EventRoute.ENQUEUE;
	}

}
