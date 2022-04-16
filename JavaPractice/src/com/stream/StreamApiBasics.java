package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiBasics {

	public static void main(String[] args) {
		// problem
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5 };
		// mai hun kejriwal
		// even gaadi ke number
		List<Integer> evenNumbers = new ArrayList<Integer>();
//		evenNumbers.forEach((i)->{
//			if(i%2==0) {
//				evenNumbers.add(i);
//			}
//		});
//		for(int i:arr) {
//			//5 %2 = 1 divisor 3
//			if(i%2==0) {
//				evenNumbers.add(i);
//			}
//		}
//		System.out.println(evenNumbers);

		// file,router - input stream -> stream api
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i : arr) {
//			if(numbers.contains(i)) {
//				continue;
//			}
			numbers.add(i);
		}
		List<Integer> result = null;
		result = numbers.stream().filter((integer) -> {
			if (integer % 2 == 0) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());

		// { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5 };

		System.out.println(result);

		result = numbers.stream().filter((integer) -> {
			if (integer % 3 == 0) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
		System.out.println(result);

		//original numbers only!!!
		result = numbers.stream().distinct().filter((integer) -> {
			if (integer % 5 == 0) {
				return true;
			} else {
				return false;
			}
		}).collect(Collectors.toList());
		System.out.println(result);
		//what is terminal op
		//after this type of operation stream is closed 
		
		List<String> names = Arrays.asList("Reflection","Collection","Stream","rajesh","deepak","navya","bhumi");
//		List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
		List<String> namesHavingA = names.stream().filter((name)->{
			if(name.contains("a")) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		System.out.println(namesHavingA);
		
		List<Integer> unsortedList = Arrays.asList(3,1,2,5,6,7,8,0,4,5,2);
		List<Integer> sortedList = unsortedList.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedList);
		
		//{1,5,6,8,3,34,2,5,-1,77,7,0,23,2,3,23,2,-32,3} positive, even,sorted ascending (chote se bada),unique
		
		int[] arrNew = {1,2,3,4,5};
		System.out.println(Arrays.stream(arrNew).filter(num->num%2==1).map(num->num*num).reduce((resultNew,num)->resultNew+=num).getAsInt());//35
	}

}
