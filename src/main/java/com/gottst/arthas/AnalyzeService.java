package com.gottst.arthas;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: Administrator
 * @date: 2020/10/18 22:24
 * @modify: 2020/10/18 22:24
 * @description:
 */
@Service
public class AnalyzeService {

	private final static Log log = LogFactory.getLog(AnalyzeService.class);

	public void allocate() {
		byte[] bytes = new byte[1024 * 1024 * 20];
		try {
			TimeUnit.MINUTES.sleep(5L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.debug("allocate bytes size:{}" + bytes.length);
	}

	public void highCPU() {
		while (true) {
			log.debug("High CPU");
		}
	}


	/**
	 * 内存溢出
	 */
	public void oom() {
		//Thread oomThread = new Thread(() -> {
		List<Person> personList = new ArrayList<>(10000);
		for (int i = 1; i < 100000000000L; i++) {
			Person person = new Person();
			person.setName("zs" + i);
			person.setAge(i);
			personList.add(person);
		}
		//});
		//oomThread.setName("oomThread");
		//oomThread.start();
	}

	/**
	 * 输出修改
	 */
	public void print() {
		System.out.println(2);
	}

	/**
	 * 死锁
	 */
	public void deadThread() {
		/** 创建资源 */
		Object resourceA = new Object();
		Object resourceB = new Object();
		// 创建线程
		Thread threadA = new Thread(() -> {
			synchronized (resourceA) {
				log.info(Thread.currentThread() + " get ResourceA");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info(Thread.currentThread() + "waiting get resourceB");
				synchronized (resourceB) {
					log.info(Thread.currentThread() + " get resourceB");
				}
			}
		});

		Thread threadB = new Thread(() -> {
			synchronized (resourceB) {
				log.info(Thread.currentThread() + " get ResourceB");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info(Thread.currentThread() + "waiting get resourceA");
				synchronized (resourceA) {
					log.info(Thread.currentThread() + " get resourceA");
				}
			}
		});
		threadA.start();
		threadB.start();
	}
}
