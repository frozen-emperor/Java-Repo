package com.output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiQues1 {

	public static void main(String[] args) {
//		stream - write any e.g. (e.g. given with filter and map to get ids of EmployeeClass whose name is jack)
//		is it possible to use name variable in the above e.g.

		EmployeeClass emp1 = new EmployeeClass(1, "shailesh1", "IT");
		EmployeeClass emp2 = new EmployeeClass(2, "shailesh", "IT");
		EmployeeClass emp3 = new EmployeeClass(3, "shailesh3", "IT");
		EmployeeClass emp4 = new EmployeeClass(4, "shailesh", "IT");
		EmployeeClass emp5 = new EmployeeClass(5, "shailesh5", "IT");
		EmployeeClass emp6 = new EmployeeClass(6, "shailesh6", "IT");
		EmployeeClass emp7 = new EmployeeClass(7, "shailesh7", "IT");
		EmployeeClass emp8 = new EmployeeClass(8, "shailesh8", "IT");
		EmployeeClass emp9 = new EmployeeClass(9, "shailesh", "IT");
		EmployeeClass emp10 = new EmployeeClass(10, "shailesh", "IT");

		List<EmployeeClass> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
		employees.add(emp7);
		employees.add(emp8);
		employees.add(emp9);
		employees.add(emp10);

		List<EmployeeClass> shaileshes = employees.stream().filter(e -> "shailesh".equals(e.getName()))
				.collect(Collectors.toList());
		
		for(EmployeeClass e:shaileshes) {
			System.out.println(e);
		}
	}

}
