package com.multithreading.demos;

/**
 * @author shsingh
 *
 *         without using sync keyword the output will be something like Good
 *         morning : Good morning : Good morning : shailesh1 Good morning :
 *         shailesh2 Good morning : shailesh2 Good morning : shailesh2 Good
 *         morning : shailesh1 Good morning : shailesh2 Good morning : shailesh1
 *         Good morning : shailesh2 Good morning : shailesh2 Good morning :
 *         shailesh2 Good morning : shailesh2 Good morning : shailesh1 Good
 *         morning : shailesh2 Good morning : shailesh1 Good morning : shailesh2
 *         Good morning : shailesh2 Good morning : shailesh1 Good morning :
 *         shailesh2 Good morning : shailesh1 Good morning : shailesh2 Good
 *         morning : shailesh2 Good morning : shailesh2 Good morning : shailesh2
 *         Good morning : shailesh1 Good morning : shailesh2 Good morning :
 *         shailesh1 Good morning : shailesh2 Good morning : shailesh2 shailesh2
 *         shailesh1 (filled with irregularities)
 */
public class SynchronizationDemo1 {

	public static void main(String[] args) {
		Display2 d = new Display2();
		Thread t1 = new MyThread(d, "shailesh1");
		Thread t2 = new MyThread(d, "shailesh2");
		Thread t3 = new MyThread(d, "shailesh3");

		t1.start();
		t2.start();
		t3.start();
	}

}

class MyThread extends Thread {
	Display2 d;
	String name;

	public MyThread(Display2 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	@Override
	public void run() {
		this.d.wish(this.name);
	}
}

class Display {
	//sync keyword will only one thread to access current d object
	public synchronized void wish(String name) {
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
