package com.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcurrentModification {

	static List<String> list = Collections.synchronizedList(new ArrayList<String>());
	
	public static void main(String[] args) {
		//Thread1 thread1 = new Thread1();
		//Thread2 thread2 = new Thread2();
		
	}

	class Thread1 implements Runnable{

		@Override
		public void run() {
			list.add("str1");
		}
		
	}

	class Thread2 implements Runnable{

		@Override
		public void run() {
			list.add("str2");
		}
		
	}

}

