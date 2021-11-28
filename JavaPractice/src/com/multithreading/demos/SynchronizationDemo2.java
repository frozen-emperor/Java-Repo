package com.multithreading.demos;

/**
 * @author shsingh
 *
 *         for static sync method class level locks are used
 */
public class SynchronizationDemo2 {

	public static void main(String[] args) {
		Display2 d = new Display2();
		Thread t1 = new MyThread2(d, "shailesh1");
		Thread t2 = new MyThread2(d, "shailesh2");
		Thread t3 = new MyThread2(d, "shailesh3");

		t1.start();
		t2.start();
		t3.start();
	}

}

class MyThread2 extends Thread {
	Display2 d;
	String name;

	public MyThread2(Display2 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	@Override
	public void run() {
		this.d.wish(this.name);
	}
}

class Display2 {
	// sync keyword will only one thread to access current d object
	public static synchronized void wish(String name) {
		for (int i = 0; i < 10; i++) {
			System.out.print("Good morning : ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
		}
	}
}
