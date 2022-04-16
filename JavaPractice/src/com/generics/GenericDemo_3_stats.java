package com.generics;

public class GenericDemo_3_stats {

	public static void main(String[] args) {
		StatsBounded<Integer> statsBounded_1 = new StatsBounded<>(new Integer[] {1,2,3,4,5,6});
		System.out.println(statsBounded_1.getAverage());
		
		StatsBounded<Double> statsBounded_2 = new StatsBounded<>(new Double[] {1.0,2.0,3.0,4.5,5.0,6.0});
		System.out.println(statsBounded_2.getAverage());
	}

}

class Stats<T> {
	T[] nums;

	public Stats(T[] nums) {
		super();
		this.nums = nums;
	}

	public double getAverage() {
		double avg = 0;
		for (T t : nums) {
//			avg = t.doubleValue(); CE since t is generic
		}
		return avg / nums.length;
	}

}

class StatsBounded<T extends Number> {
	T[] nums;

	public StatsBounded(T[] nums) {
		super();
		this.nums = nums;
	}

	public double getAverage() {
		double avg = 0;
		for (T t : nums) {
			avg += t.doubleValue();
		}
		return avg / nums.length;
	}

}