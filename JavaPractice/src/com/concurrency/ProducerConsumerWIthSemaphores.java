package com.concurrency;

import java.util.concurrent.Semaphore;

public class ProducerConsumerWIthSemaphores {

	public static void main(String[] args) {
		// with normal wait notify pnc we cannot control whether producer
		// or consumer thread will get first lock but with semaphores
		// this ability to set the initial sync state is one of the powerful features of
		// semaphores

		// Synchronized allows only one thread of execution to access the resource at
		// the same time.
		// Semaphore allows up to n (you get to choose n) threads of execution to access
		// the resource at the same time.
		Q q = new Q();
		Thread consumer = new Thread(()->{
			for(int i=0;i<5;i++) {
				System.out.println("consumed: "+q.get());
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}); 
		
		Thread producer = new Thread(()->{
			for(int i=0;i<5;i++) {
				q.put(i);
				System.out.println("produced: "+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}); 
		
		//despite of consumer starting first it won't get semaphore lock and wait for producer
		consumer.start();
		producer.start();
	}

}

class Q {
	private Semaphore consumerSemaphore = new Semaphore(0); // during start since n is empty the consumer will not get
															// access
	private Semaphore producerSemaphore = new Semaphore(1); // producer thread will get access so it can feed the value
															// first
	int n;

	public int get() {
		try {
			// during start even if con thread calls this method it won't get access since
			// it is zero
			consumerSemaphore.acquire();
			return this.n;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			producerSemaphore.release();
		}
		return 0;
	}
	
	public void put(int n) {
		try {
			producerSemaphore.acquire();
			this.n = n;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			consumerSemaphore.release();
		}
	}
}