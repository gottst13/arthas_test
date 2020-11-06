package com.gottst.arthas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author: Administrator
 * @date: 2020/10/18 23:01
 * @modify: 2020/10/18 23:01
 * @description:
 */
@RestController
public class AnalyzeController {

	@Autowired
	AnalyzeService analyzeService;

	@GetMapping("/oom")
	public void oom() {
		analyzeService.oom();
	}

	@GetMapping("/allocate")
	public void allocate() {
		analyzeService.allocate();
	}

	@GetMapping("/highCPU")
	public void highCPU() {
		analyzeService.highCPU();
	}


	@GetMapping("/deadLock")
	public String deadLock() {
		analyzeService.deadThread();
		return "DeadLock";
	}


	@GetMapping("/print")
	public void print() {
		while (true) {
			analyzeService.print();
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
