package com.gottst.threadpool;

import java.util.concurrent.*;

/**
 * @author: Administrator
 * @date: 2020/10/25 22:50
 * @modify: 2020/10/25 22:50
 * @description: 线程池测试demo
 */
public class ThreadExecutorDemo {


	public static void main(String[] args) {

		ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 10,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("ThreadExecutorDemo Test");
			}
		});


	}





}
