package com.concurrency;

public class StopThreadAfterTimeFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(()->{
			System.out.println("exceuting....1");
			//interrupted is also a volatile variable in Thread class
			while(!Thread.currentThread().isInterrupted()) {
				System.out.println("exceuting....2");
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		});
		
		
		t1.start();
		
		Thread.sleep(10);
		//basically will set the interrupted flag to true and flush to shared cache
		t1.interrupt();
	}

}
