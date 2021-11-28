package com.multithreading.interThread;

import java.util.LinkedList;

public class InterThreadDemo2 {

	public static void main(String[] args) throws InterruptedException {
		LinkedList<String> orderStack = new LinkedList<String>();
		Thread waiter1 = new Thread(new Waiter1(orderStack));
		Thread waiter2 = new Thread(new Waiter1(orderStack));
		Thread chef = new Thread(new Chef(orderStack));

		waiter1.start();
		 waiter2.start();
		chef.start();

		waiter1.join();
		 waiter2.join();
		chef.join();
	}

}

class Waiter1 implements Runnable {

	LinkedList<String> orderStack;

	public Waiter1(LinkedList<String> orderStack) {
		this.orderStack = orderStack;
	}

	@Override
	public void run() {
		synchronized (orderStack) {
			while (true) {
				if (orderStack.isEmpty()) {
					try {
						orderStack.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("waiter 1 got : " + orderStack.pop());
					Thread.yield();
				}
			}
		}
	}

}

class Waiter2 implements Runnable {

	LinkedList<String> orderStack;

	public Waiter2(LinkedList<String> orderStack) {
		this.orderStack = orderStack;
	}

	@Override
	public void run() {
		synchronized (orderStack) {
			while (true) {
				if (orderStack.isEmpty()) {
					try {
						orderStack.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("waiter 1 got : " + orderStack.pop());
					orderStack.notify();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}

class Chef implements Runnable {

	LinkedList<String> orderStack;
	int counter = 0;

	public Chef(LinkedList<String> orderStack) {
		this.orderStack = orderStack;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (orderStack) {

				if (orderStack.size() > 3) {
					orderStack.notifyAll();
				} else {
					orderStack.push("order no. " + counter++);
					System.out.println("chef added order no. " + counter);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}

	}

}
