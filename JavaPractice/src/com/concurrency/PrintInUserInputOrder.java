package com.concurrency;

import java.util.concurrent.Semaphore;

public class PrintInUserInputOrder {

	public static void main(String[] args) throws InterruptedException {
		int[] arr = { 3, 1, 2 };
		


		Runnable printFirst = () -> System.out.print("first,");
		Runnable printSecond = () -> System.out.print("second,");
		Runnable printThird = () -> System.out.print("third,");

		Runnable[] runnables = { printFirst, printSecond, printThird };

		Foo foo = new Foo();
		int i=0;
		while(i<10) {
			
			if(i==2) {
				System.out.println();
			}
		Thread t1 = new Thread(() -> {
			
			try {				
				foo.first(printFirst);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		

		Thread t2 = new Thread(() -> {
			try {
				foo.second(printSecond);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		

		Thread t3 = new Thread(() -> {
			try {
				foo.third(printThird);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		
		t1.join();
		t2.join();
		t3.join();
		System.out.println();
		i++;
		}
		
		
	}

}

class Foo {
	Semaphore semaphore = new Semaphore(1,false);
	
	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		semaphore.acquire(1);
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		semaphore.release(2);
	}

	public void second(Runnable printSecond) throws InterruptedException {
		semaphore.acquire(2);
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		semaphore.release(3);
	}

	public void third(Runnable printThird) throws InterruptedException {
		semaphore.acquire(3);
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
		semaphore.release(1);
	}
}
