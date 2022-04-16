package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAdvanced {

	public static void main(String[] args) {
		List<List<Employee>> listOfEmployees = new ArrayList<List<Employee>>();
		listOfEmployees.add(Arrays.asList(new Employee(1, "shailesh", 100000), new Employee(0, "harshit", 10000),
				new Employee(0, "akash", 500000)));
		listOfEmployees.add(Arrays.asList(new Employee(0, "kailas", 200000), new Employee(0, "sid", 1000),
				new Employee(0, "sonu", 50000)));
		listOfEmployees.add(Arrays.asList(new Employee(0, "kailas", 200000)));

//		distinct() first tests using hashCode and then if hashCodes are the same, uses the equals method.
		List<Employee> distinctAndGreaterThanFiftyK = listOfEmployees
				.stream()
				.flatMap(list -> list.stream())
				.distinct()
				.filter(e -> e.getSalary() > 50000)
				.collect(Collectors.toList());
		System.out.println(distinctAndGreaterThanFiftyK);

		Map<Integer, List<Employee>> distinctKVAndGreaterThanFiftyK = listOfEmployees
				.stream()
				.flatMap(list -> list.stream())
				.distinct()
				.filter(e -> e.getSalary() > 50000)
				.collect(Collectors.groupingBy(
						e -> Integer.valueOf(((Employee) e).getId())));
		System.out.println(distinctKVAndGreaterThanFiftyK);

		String name = listOfEmployees.stream().flatMap(list -> list.stream()).distinct().map(Employee::getName)
				.reduce((name1, name2) -> {
					return name1.length() > name2.length() ? name1 : name2;
				}).orElse(null);
		System.out.println(name);

//		Employee e = null; ******************
//		e.num = "";
//		
//		I i = new I() {
//		};
//		i.function();
	}

}

interface I {
	static int num = 0;

	default void function() {
		System.out.println("feault");
	}
}

class Employee {
	static String num;
	int id;
	String name;
	double salary;

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o instanceof Employee) {
			Employee e = ((Employee) o);
			return e.getId() == this.getId() && e.getName() == this.getName() && e.getSalary() == this.getSalary();
		}
		return false;

	}

	@Override
	public int hashCode() {
		return id;
	}

}
