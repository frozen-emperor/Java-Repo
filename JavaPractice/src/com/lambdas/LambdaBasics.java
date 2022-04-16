package com.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaBasics {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		numbers.forEach(new Consumer<Integer>() {
			public void accept(Integer n) {
				System.out.println(n + ",");
			}
		});//this creates class file
		numbers.forEach(n -> System.out.println(n + ","));//this doesn't
		numbers.forEach(n -> System.out.println(n + ","));
		numbers.forEach(n -> System.out.println(n + ","));
	}
}
