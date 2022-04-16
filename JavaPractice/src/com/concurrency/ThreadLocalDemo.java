package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

	static ThreadLocal<Counter> counterWhichTracksLastThreadsCount = ThreadLocal.withInitial(() -> {
		return new Counter();
	});

	public static void main(String[] args) {
		// used for sharing one resource per thread according to the
		// number of thtreads in the pool to avoid data incosistency

		ExecutorService threadExecutor = Executors.newFixedThreadPool(4);
		// if same thread is used again the state of int count won't change
		// hence if 5 is replaced with 100. the count values keep of increasing
		for (int i = 0; i < 5; i++) {
			threadExecutor.submit(() -> {
				for (int j = 0; j < 10; j++) {
					System.out.println("+++++++++++++++++++++++++++++++");
					counterWhichTracksLastThreadsCount.get().count++;
					System.out
							.println(Thread.currentThread().getName() + " : " + counterWhichTracksLastThreadsCount.get()
									+ " : " + counterWhichTracksLastThreadsCount.get().count);
					//here count cn reach to 100 also
				}
			});
		}
		
		
		for (int i = 0; i < 5; i++) {
			threadExecutor.submit(() -> {
				for (int j = 0; j < 10; j++) {
					System.out.println("=======================================");
					counterWhichTracksLastThreadsCount.get().count++;
					System.out.println(Thread.currentThread().getName() + " : " + counterWhichTracksLastThreadsCount.get()
							+ " : " + counterWhichTracksLastThreadsCount.get().count);
				}
				counterWhichTracksLastThreadsCount.get().count = 0;
				//will reset to 0 everytime one task is completed by a thread/despite of it's lifecycle
			});
		}
	}

	static class Counter {
		int count;

		public Counter(int init) {
			count = init;
		}

		public Counter() {
		}
	}

}
