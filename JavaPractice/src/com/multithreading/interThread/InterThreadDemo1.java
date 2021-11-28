package com.multithreading.interThread;

public class InterThreadDemo1 {

	public static void main(String[] args) throws InterruptedException {
		ThreadB b =  new ThreadB();
		b.start();
		//if b gets chance first then main will go into infinite waiting state
		//to check this uncomment sleep and wait(1000)
		//to avoid this pass amount of time in wait method
		Thread.sleep(100);
		synchronized (b) {
			//remember sync makes b one thread per time not main thread gets lock permanently
			System.out.println("main thread calling wait");
			b.wait();
			//main thread will release the monitor over here
			
			//this will avoid infinite waiting for main thread if b get chance first
			//			b.wait(1000);
			
			//why we don't use join or sleep over here 
			//sleep will waste time since processor can complte the loop in nano seconds so remaining time will waste
			//join will wait until whole run method completes, but if we wan notification in between somewhere then?
			System.out.println("main thread got notification");
			System.out.println(b.total);
		}
	}

}

class ThreadB extends Thread {
	int total = 0;

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("child thread starts calculation");
			for (int i = 1; i <= 100; i++) {
				total += i;
			}
			System.out.println("child thread finished calculation");
			this.notify();
		}
		//1 crore lines <- join will execute all of this lines so bad choice
	}
}
