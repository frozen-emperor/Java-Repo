package com.output;

import java.util.HashMap;

public class HashMapOutputQuestions {

	public static void main(String[] args) {
		String s1 = "shailesh";
		String s2 = "shailesh";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put(s1, 1);
		map.put(s2, 2); //<- this is the same ref due to string pool so replace occurs
		System.out.println(map.size()); //<-1
		System.out.println(map);
		
		//Scenario
		Employee e1 = new Employee(1, "shailesh");
		Employee e2 = new Employee(1, "shailesh");
		HashMap<Employee, Integer> map2 = new HashMap<Employee, Integer>();
		map2.put(e1, 1);
		map2.put(e2, 2); //e1 and e2 have different hashcodes
		System.out.println(map2.size()); //<-2
		System.out.println(map2);
	}

}

class Employee {
	int id;
	String name;

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
