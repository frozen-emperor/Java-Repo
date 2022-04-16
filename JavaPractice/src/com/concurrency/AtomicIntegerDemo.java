package com.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	public static void main(String[] args) {
		//volatile won;t be a good choice here
		//since volatile gives visibilty but not synchronization
		//increment is read i and ++i (at processor)
		//so if t1 reads and then t2 also reads i=1
		//then t1 i++ and t2 also i++ then it would be 2. 
		//where it should be 3. So this flush and refresh is not guaranteed
		//volatile singleton is the best usecase wwhere we need visibility even after getting lock 
		//of the instance reference
		
		//volatile - gives visibility not sync (not an alternative for sync)
		AtomicInteger i = new AtomicInteger(0);

		Runnable r = () -> {
			for (int j = 0; j < 10; j++)
				System.out.println(i.incrementAndGet());
		};
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
