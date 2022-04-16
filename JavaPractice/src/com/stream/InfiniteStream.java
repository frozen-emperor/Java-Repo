package com.stream;

import java.util.stream.Stream;

public class InfiniteStream {

	public static void main(String[] args) {
		System.out.println(Stream.iterate(100, e -> e + 1)); // op java.util.stream.ReferencePipeline$Head@4c3e4790
		// yes it is an infinite stream but won't do aything
		// since we haven;t called it to do anything

		// immutability leads to no side effect, no side effect leads to laziness

		// problem : find sum of all even numbers whose
		// square root > 20 till n from k
		int k = 121, n = 51;
		System.out.println(compute(n, k));
	}

	static int compute(int n, int k) {
//		int result = 0;
//		
//		int count = 0;
//		int index = k;
//		while(count<n) {
//			if(index %2==0&&Math.sqrt(index) >20) {
//				result+=index*2;
//				count++;
//			}
//			index++;
//		}
//		
//		return result;

		return Stream.iterate(k, e -> e + 1) 		//unbounded,lazy
				.filter(e -> e % 2 == 0)    		//unbounded,lazy
				.filter(e -> Math.sqrt(e) > 20)		//unbounded,lazy
				.mapToInt(e -> e * 2)				//unbounded,lazy
				.limit(n)							//sized,lazy
				.sum();								//sum is the one which triggers the eval
		
		//to check if function is lazy or not check the return type of the function
		//if it returns stream it's lazy
		//basically intermediate ops are always lazy
		
		//the difference between 2 codes is for one you don;t have to check what value has to
		//be of < or <=n
	}

}
