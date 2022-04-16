package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamBasics {

	public static void main(String[] args) {
		int[] arr = new int[1000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		for(int i:arr) {
			System.out.print(i+",");
		}	}

}
