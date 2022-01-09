package com.design.singleton;

public class SingletonDesignPatternDemo {

	public static void main(String[] args) {
		// 1.simple impl
		// this will return same instance on each call
		SimpleSingleton simpleSingleton1 = SimpleSingleton.getInstance();
		SimpleSingleton simpleSingleton2 = SimpleSingleton.getInstance();
		System.out.println(
				"SimpleSingleton & simpleSingleton1 are same objects : " + (simpleSingleton1 == simpleSingleton2));

		// above code is all good but has one small limitation
		// which are called THREADS!!!
		Thread t1 = new Thread(() -> {

			SimpleSingleton simpleSingleton3 = SimpleSingleton.getInstance();
			System.out.println(simpleSingleton3);
		});
		Thread t2 = new Thread(() -> {

			SimpleSingleton simpleSingleton3 = SimpleSingleton.getInstance();
			System.out.println(simpleSingleton3);
		});
		t1.start();
		t2.start();
		// in above example it is possible that both threads call
		// instance = new SimpleSingleton(); at once and rewrite each other's flow
		// com.design.SimpleSingleton@6827b445 <-to activate this behavior comment
		// starting lines of getInstance
		// com.design.SimpleSingleton@28c13eae
		// not a good idea

		// 2.synchronized version of Singleton
		Thread t3 = new Thread(() -> {

			SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
			System.out.println(synchronizedSingleton);
		});
		Thread t4 = new Thread(() -> {

			SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
			System.out.println(synchronizedSingleton);
		});
		t3.start();
		t4.start();
		// the synchronized keyword solves the race condition but
		// it increases overhead since locking will be present even after first init of
		// instance
		// 100 threads -> result into waiting in sequence VERY BAD IDEA

		// 3. Eager Instantiation Version
		Thread t5 = new Thread(() -> {

			EagerInstantiatedSingleton eagerInstantiatedSingleton = EagerInstantiatedSingleton.getInstance();
			System.out.println(eagerInstantiatedSingleton);
		});
		Thread t6 = new Thread(() -> {

			EagerInstantiatedSingleton eagerInstantiatedSingleton = EagerInstantiatedSingleton.getInstance();
			System.out.println(eagerInstantiatedSingleton);
		});
		t5.start();
		t6.start();
		// since instance will be directly created by JVM
		// so no issues for threads but in case if we never need this singleton object
		// then??
		// it just uses unnecessary memory

		// 4. Using volatile and "double-check locking"		
		Thread t7 = new Thread(() -> {

			DoubleCheckLockedSingleton doubleCheckLockedSingleton = DoubleCheckLockedSingleton.getInstance();
			System.out.println(doubleCheckLockedSingleton);
		});
		Thread t8 = new Thread(() -> {

			DoubleCheckLockedSingleton doubleCheckLockedSingleton = DoubleCheckLockedSingleton.getInstance();
			System.out.println(doubleCheckLockedSingleton);
		});
		t7.start();
		t8.start();
		
		//there is still no best version but any of them could be used as per usecase
	}

}

class SimpleSingleton {
	private static SimpleSingleton instance;

	private SimpleSingleton() {

	}

	public static SimpleSingleton getInstance() {
		if (instance == null) {
			instance = new SimpleSingleton();
		}
		return instance;
	}
}

class SynchronizedSingleton {
	private static SynchronizedSingleton instance;

	private SynchronizedSingleton() {

	}

	// synchronized will allow only one thread at a time
	public static synchronized SynchronizedSingleton getInstance() {
		if (instance == null) {
			instance = new SynchronizedSingleton();
		}
		return instance;
	}
}

class EagerInstantiatedSingleton {
	private static EagerInstantiatedSingleton instance = new EagerInstantiatedSingleton();

	private EagerInstantiatedSingleton() {

	}

	public static EagerInstantiatedSingleton getInstance() {
		return instance;
	}
}

class DoubleCheckLockedSingleton {
	// when a volatile object is updated for one thread, the status is sent
	// to every thread using it and it's state is changed
	private volatile static DoubleCheckLockedSingleton instance;

	private DoubleCheckLockedSingleton() {

	}

	public static DoubleCheckLockedSingleton getInstance() {
		if (instance == null) {
			// if null only then take lock
			synchronized (DoubleCheckLockedSingleton.class) {
				// after taking lock it's possible that instance was created maybe by previous
				// thread
				// from which we took lock, so one more check ( how we can be sure-> since it is
				// volatile)
				// if previous thread updated the instance we'll get to know it right away
				if (instance == null) {
					instance = new DoubleCheckLockedSingleton();
				}
			}
		}
		return instance;
	}
}
