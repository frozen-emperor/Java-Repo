package com.output;

import java.util.PriorityQueue;
import java.util.Queue;

public class ProducerConsumerProblem {

	public static void main(String[] args) {
		Queue<String> q = new PriorityQueue<String>();
		ProducerThread producer = new ProducerThread(q);
		ConsumerThread consumer = new ConsumerThread(q);

		producer.start();
		consumer.start();
	}

}

class ConsumerThread extends Thread {
	private Queue<String> q;
	int i;

	ConsumerThread(Queue<String> q) {
		this.q = q;
	}

	@Override
	public void run() {
		for (i = 1; i < 10; i++) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void consume() throws InterruptedException {
		synchronized (q) {
			if (this.q.isEmpty()) {
				System.out.println("consumer waiting for 100ms");
				q.wait();
				i--;
			} else {
				System.out.println("consumed : " + q.poll());
				q.notify();
			}
		}
	}
}

class ProducerThread extends Thread {
	private Queue<String> q;
	int i;

	ProducerThread(Queue<String> q) {
		this.q = q;
	}

	@Override
	public void run() {
		for (i = 1; i < 10; i++) {
			produce("shailesh_" + i);
		}
	}

	private void produce(String string) {
		synchronized (q) {
			if (q.isEmpty()) {
				System.out.println("producer added " + string + " to the queue");
				q.add(string);

				q.notify();
				System.out.println("producer sent notification");
			} else {
				try {
					q.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// i-- will avoid the  
				i--;
			}
		}
	}

}
