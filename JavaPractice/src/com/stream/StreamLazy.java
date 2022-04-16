package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLazy {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

		// problem: find first even number greater than 3 and double it
		// imperative style
		for (int i : numbers) {
			if (i > 3 && i % 2 == 0) {
				System.out.println(i * 2);
				break;
			}
		}
		// takes 8 units of work
		// check if 1 >3 - 1unit
		// check if 2 >3 - 1unit
		// check if 3 >3 - 1unit
		// check if 5 >3 - 1unit
		// check if 5 % 2 == 0 - 1unit
		// check if 4 >3 - 1unit
		// check if 4 % 2 == 0 - 1unit
		// double the 4 - 1unit

		// functional style
		System.out.println(
				numbers.stream()
						.filter(StreamLazy::isGT3)
						.filter(StreamLazy::isEven)
						.map(StreamLazy::doubleIt)
						.findFirst());
		// as first it seems like
		// 20 units for first filter
		// 17 for even filter
		// 9 for double
		// 46 units of work

		// but streams are lazy and the work actually goes like
		// check if 1 >3 - 1unit - intermediate op ends
		// check if 2 >3 - 1unit - intermediate op ends
		// check if 3 >3 - 1unit - intermediate op ends
		// check if 5 >3 - 1unit
		// check if 5 % 2 == 0 - 1unit - intermediate op ends
		// check if 4 >3 - 1unit
		// check if 4 % 2 == 0 - 1unit
		// double the 4 - 1unit - terminal op reached and stream ends
		// so in reality it takes only 8 units of work
		// to check run the code

		// output
		// isGT3 : 1
		// isGT3 : 2
		// isGT3 : 3
		// isGT3 : 5
		// isEven : 5
		// isGT3 : 4
		// isEven : 4
		// doubleIt : 4
		// Optional[8]

		System.out.println(
				numbers.stream()
						.filter(StreamLazy::isGT3)
						.filter(StreamLazy::isEven)
						.map(StreamLazy::doubleIt)
						.collect(Collectors.toList()));
		// 46 ops since we are collecting same with imperative style

		System.out.println("Will stream run without any terminal op??");
		// 2.Non evaluation
		numbers.stream()
				.filter(StreamLazy::isGT3)
				.filter(StreamLazy::isEven)
				.map(StreamLazy::doubleIt);
		System.out.println("done");
		// nope it won't since streams are lazy
		
		//also dont print stuff in functions 
		//since it won;t be good to use lazy eval in this way. for debug it's okay
		
	}

	static boolean isGT3(int number) {
		System.out.println("isGT3 : " + number);
		return number > 3;
	}

	static boolean isEven(int number) {
		System.out.println("isEven : " + number);
		return number % 2 == 0;
	}

	static int doubleIt(int number) {
		System.out.println("doubleIt : " + number);
		return number * 2;
	}

}
