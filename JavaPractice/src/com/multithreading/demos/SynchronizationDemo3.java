package com.multithreading.demos;

/**
 * @author shsingh
 *
 */
public class SynchronizationDemo3 {

	public static void main(String[] args) {
		Display3 d = new Display3();
		MyThreadNumber tn = new MyThreadNumber(d, "number thread");
		MyThreadChar tc = new MyThreadChar(d, "char thread");
		tn.start();
		tc.start();
	}

}

class MyThreadNumber extends Thread {
	Display3 d;
	String name;

	public MyThreadNumber(Display3 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	@Override
	public void run() {
		this.d.displayn();
	}
}
class MyThreadChar extends Thread {
	Display3 d;
	String name;

	public MyThreadChar(Display3 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	@Override
	public void run() {
		this.d.displayc();
	}
}

class Display3 {
	// sync keyword will only one thread to access current d object
	public synchronized void displayn() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	// sync keyword will only one thread to access current d object
		public synchronized void displayc() {
			for (int i = 65; i < 85; i++) {
				System.out.print((char)i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}
		}
}
