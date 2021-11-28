package com.multithreading.daemon;

public class DaemonThreadDemo1 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().isDaemon());
		// Thread.currentThread().setDaemon(true); IllegalThreadStateException
		
		Thread t = new Thread();
		System.out.println(t.isDaemon());
		t.setDaemon(true);
		t.start();
		System.out.println(t.isDaemon());
	}

}
