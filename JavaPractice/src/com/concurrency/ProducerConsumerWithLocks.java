package com.concurrency;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//caution:if number of extracted numbers and produced numbers are different
		//one of the threads would go into infinite waiting state
		MyQueue queue = new MyQueue();
		Thread consumer = new Thread(() -> {
			int numberExtracted = 0;
			while (true) {
				// will break after 10 numbers extracted
				if (numberExtracted > 9) {
					break;
				}
				int a = queue.getFromQueue();
				System.out.println("consumed :" + a);
				numberExtracted++;
			}
		});

		Thread producer = new Thread(() -> {
			int i = 1;
			while (true) {
				if (i > 10) {
					break;
				}
				queue.putIntoQueue(i);
				i++;
			}
		});

		System.out.println(producer.getName());
		System.out.println(consumer.getName());
		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class MyQueue {
	ReentrantLock lock = new ReentrantLock(true);
	int max = 10;
	private Condition notEmptyCondition = lock.newCondition();
	private Condition notFullCondition = lock.newCondition();
	private Queue<Integer> q;

	public MyQueue() {
		this.q = new LinkedList<Integer>();
	}

	public void putIntoQueue(int a) {
		lock.lock();
		try {
			while (q.size() == 10) {
				notFullCondition.await(10, TimeUnit.SECONDS);
			}
			q.add(a);
			notEmptyCondition.signalAll();
			System.out.println("producer added : " + a);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			lock.unlock();
			System.out.println("producer released lock");
		}
		
	}

	public int getFromQueue() {
		lock.lock();
		try {
			while (this.q.isEmpty()) {
				//else it would wait forever
				notEmptyCondition.await(10, TimeUnit.SECONDS);
			}
			notFullCondition.signalAll();
			return q.poll();			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			lock.unlock();
			System.out.println("consumer released lock");
		}
		return 0;
	}
}
