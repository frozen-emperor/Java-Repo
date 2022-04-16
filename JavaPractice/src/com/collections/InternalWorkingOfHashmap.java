package com.collections;

import java.util.HashMap;
import java.util.Map;

public class InternalWorkingOfHashmap {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("naveen", 100);
		map.put("Tom", 200);
		map.put("Lisa",300);
		map.put("Peter", 400);
		map.put("Robby", 600);
		
		map.put(null, 800);
		map.put(null, 900);
		//won't be an exception since put will replace 800 to 900
		System.out.println(map);
	}

}
