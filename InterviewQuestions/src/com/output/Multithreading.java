package com.output;

public class Multithreading {

	public static int x = 10;

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable1());
		Thread t2 = new Thread(new Runnable1());

		t1.start();
		t2.start();
	}
	
	//below synchronized keyword protects the x from
	//same time access from diff threads to avoid race condition
	public static synchronized void increment() {
		for (int i = 0; i < 10; i++) {
			Multithreading.x++;
			System.out.println(Thread.currentThread().getName() + " : x = " + Multithreading.x);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Runnable1 implements Runnable {

	@Override
	public void run() {
		Multithreading.increment();
	}
// without synchronized keyword following o/p will be there
//          Thread-0 : x = 12
//	        Thread-1 : x = 12
//			Thread-0 : x = 14
//			Thread-1 : x = 14
//			Thread-0 : x = 16
//			Thread-1 : x = 16
//			Thread-1 : x = 17
//			Thread-0 : x = 17
//			Thread-0 : x = 19
//			Thread-1 : x = 19
//			Thread-0 : x = 20
//			Thread-1 : x = 20
//			Thread-0 : x = 21
//			Thread-1 : x = 21
//			Thread-0 : x = 22
//			Thread-1 : x = 22
//			Thread-0 : x = 24
//			Thread-1 : x = 24
//			Thread-1 : x = 26
//			Thread-0 : x = 26
}