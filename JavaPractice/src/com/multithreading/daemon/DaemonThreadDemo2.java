package com.multithreading.daemon;

public class DaemonThreadDemo2 {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.setDaemon(true);
		t.start();		
		//t will terminated as soon as main thread complete it's execution
		//since daemon threads are not useful if there's no non daemon threads
		//because daemon threads are only for support of non daemon threads
		System.out.println("end of main thread");
	}

}
class MyThread extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
