package com.gottst.arthas;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Administrator
 * @date: 2020/10/19 23:32
 * @modify: 2020/10/19 23:32
 * @description:
 */
public class NameThreadFactory implements ThreadFactory {

	private final AtomicInteger threadNumber = new AtomicInteger(1);

	@Override
	public Thread newThread(Runnable r) {
		if (r instanceof Thread) {
			return (Thread) r;
		}
		Thread thread = new Thread(r.getClass().getName() + "-" + threadNumber.getAndIncrement());
		return thread;
	}
}
