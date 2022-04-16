package com.wissen;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		Employee e=new Employee(0, "name", new ArrayList<String>());
		HashMap<Employee, String> map =  new HashMap<Employee, String>();
		map.put(e, "0");
		map.put(new Employee(1, "name 2", new ArrayList<String>()), "1");
		System.out.println(map); 
		//1. only hashcode overriden and return constant value
		//-> since hashcode will be equal for all employees then equals of object class will be called
		//which will not be equal and new key will e added
		
		//2.both implemented
	}

}
