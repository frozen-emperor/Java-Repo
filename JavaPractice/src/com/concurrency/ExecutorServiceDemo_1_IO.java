package com.concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo_1_IO {

	static File file = new File("C:\\Users\\mails\\git\\Java-Repo\\JavaPractice\\src\\com\\concurrency\\readFile");

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(50);
		// good to have more threads in case of io so they would be atleast ready until 1 of 4 threads
		//currently running terminates so they can quickly start
		//but same in normal non io ops, it won't be needed since it would be very fast
		for (int i = 0; i < 100; i++) {
			executorService.execute(new Task("Task_" + i));
		}
	}

	static class Task implements Runnable {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(file));

				System.out.println(name + " task is running on " + Thread.currentThread().getName());
				String st;
				while ((st = br.readLine()) != null)
					System.out.println(st);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
