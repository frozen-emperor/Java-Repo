package com.multithreading.interThread;

public class DeadLockDemo1 extends Thread{
	A a = new A();
	B b = new B();
	
	public void m1() {
		this.start();
		a.d1(b); //this line executed by main thread since m1 is simple method call
		//main thread will call d1 and  will take a's lock and wait for b's lock after 1000ms
		//until then child thread will call d2 method and take lock of b and after 1000ms will wait 
		//for a's lock
	}
	
	@Override
	public void run() {
		b.d2(a);//this executed by deadlock thread 
	}

	public static void main(String[] args) {
		new DeadLockDemo1().m1();
	}

}

class A {
	public synchronized void d1(B b) {
		System.out.println("Thread 1 starts execution of d1 method");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.last();
	}

	public synchronized void last() {
		System.out.println("A's last method");
	}
}

class B {
	public synchronized void d2(A a) {
		System.out.println("Thread 2 starts execution of d2 method");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.last();
	}

	public synchronized void last() {
		System.out.println("B's last method");
	}
}
