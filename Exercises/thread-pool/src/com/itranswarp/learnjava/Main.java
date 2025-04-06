package com.itranswarp.learnjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	public static void main(String[] args) {
//		ExecutorService es = Executors.newFixedThreadPool(4);
//		for (int i = 0; i < 6; i++) {
//			es.submit(new Task("" + i));
//		}
//		es.shutdown();
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
		for (int i = 0; i < 6; i++) {
			ses.scheduleWithFixedDelay(new Task(""+i),2,3,TimeUnit.SECONDS);
		}
		try {
			Thread.sleep(10000);
			ses.shutdown();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Task implements Runnable {

	private final String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("start task " + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		System.out.println("end task " + name);
	}
}
