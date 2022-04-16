package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo_1 {

	public static void main(String[] args) {
		//get number of cores
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("number of cores"+coreCount);
		
		//good to have only n threads if n cores are there
		//since 1 java thread is 1 os thread. so 1000 threads is stupid idea, os will not allow anyway
		ExecutorService executorService = Executors.newFixedThreadPool(coreCount);
		for(int i=0;i<100;i++) {
			executorService.execute(new Task("Task_"+i));
		}
	}

	static class Task implements Runnable {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println(name+" task is running on "+Thread.currentThread().getName());
		}

	}

}
