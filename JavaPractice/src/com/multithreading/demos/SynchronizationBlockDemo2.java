package com.multithreading.demos;

/**
 * @author shsingh
 *
 */
public class SynchronizationBlockDemo2 {

	public static void main(String[] args) {
		Display5 d1 = new Display5();
		Display5 d2 = new Display5();
		
		MyThread5 t1 = new MyThread5(d1, "shailesh");
		MyThread5 t2 = new MyThread5(d2, "shailesh2");

		t1.start();
		t2.start();
	}

}

class MyThread5 extends Thread {
	Display5 d;
	String name;

	public MyThread5(Display5 d, String name) {
		super();
		this.d = d;
		this.name = name;
	}

	@Override
	public void run() {
		d.wish(name);
	}
}

class Display5 {
	public void wish(String name) {
		// if we use this over here then the lock will be on d1 or d2 
		// which will result in irregular output
		// but class level lock will allow only one thread
		// to access this block
		synchronized (Display5.class) {

			for (int i = 0; i < 10; i++) {
				System.out.print("Good Morning : ");
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
