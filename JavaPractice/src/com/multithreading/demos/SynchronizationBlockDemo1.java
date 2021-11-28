package com.multithreading.demos;

/**
 * @author shsingh
 *
 */
public class SynchronizationBlockDemo1 {

	public static void main(String[] args) {
		Display4 d = new Display4();
		MyThread4 t1 = new MyThread4(d, "shailesh");
		MyThread4 t2 = new MyThread4(d, "shailesh2");

		t1.start();
		t2.start();
	}

}

class MyThread4 extends Thread {
	Display4 d;
	String name;

	public MyThread4(Display4 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	@Override
	public void run() {
		d.wish(name);
	}
}

class Display4 {
	public void wish(String name) {
		// there could be lakhs of lines before this
		// sync block only restricts relevant code
		// so other code can be present in non sync area
		// and available for other threads
		synchronized (this) {

			for (int i = 0; i < 10; i++) {
				System.out.println("Good Morning : ");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(name);
			}
		}
	}
}
