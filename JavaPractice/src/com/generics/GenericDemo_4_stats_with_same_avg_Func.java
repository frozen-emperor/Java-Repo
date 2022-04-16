package com.generics;

public class GenericDemo_4_stats_with_same_avg_Func {

	public static void main(String[] args) {
		StatsBoundedWithSameAvg<Integer> statsBounded_1 = new StatsBoundedWithSameAvg<>(new Integer[] { 1, 2, 3, 4, 5, 6 });
		System.out.println(statsBounded_1.getAverage()); //3.5

		StatsBoundedWithSameAvg<Double> statsBounded_2 = new StatsBoundedWithSameAvg<>(new Double[] { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 });
		System.out.println(statsBounded_2.getAverage()); //3.5
		
		System.out.println(statsBounded_1.sameAverage(statsBounded_2)); //true
	}

}

class StatsBoundedWithSameAvg<T extends Number> {
	T[] nums;

	public StatsBoundedWithSameAvg(T[] nums) {
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
	//wildcard doesn't restrict the type of object but the above
	//class declaration with T extends Number does
	public boolean sameAverage(StatsBoundedWithSameAvg<?> otherStats) {
		if (this.getAverage() == otherStats.getAverage()) {
			return true;
		}

		return false;
	}
	
//  will not work for anything apart from T and T
//	public boolean sameAverage(StatsBounded<T> otherStats) {
//		if (this.getAverage() == otherStats.getAverage()) {
//			return true;
//		}
//
//		return false;
//	}

}