package com.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo_1 {

	public static void main(String[] args) {
		//main thread will await for latch until the latch turns 0 by thread t
		CountDownLatch latch = new CountDownLatch(5);
		
		Thread t = new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println(i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				latch.countDown();
			}
		});
		t.start();
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("latch opened");
	}

}
