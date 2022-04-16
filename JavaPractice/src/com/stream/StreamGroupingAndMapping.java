package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamGroupingAndMapping {

	static List<Person> createPeople() {
		return Arrays.asList(new Person("Sara", Gender.FEMALE, 20), new Person("Sara", Gender.FEMALE, 22),
				new Person("Bob", Gender.MALE, 20), new Person("Paula", Gender.FEMALE, 32),
				new Person("Paul", Gender.MALE, 32), new Person("Jack", Gender.MALE, 2),
				new Person("Jack", Gender.MALE, 20), new Person("Jill", Gender.FEMALE, 12));
	}

	public static void main(String[] args) {
		List<Person> people = createPeople();
		
		//mapping persons by their name and age
		System.out.println(people
				.stream()
				.collect(Collectors.toMap(
						person -> person.getName() + "_" + person.getAge(),
						person -> person)));
		// out put
//		{Bob_20=Person [name=Bob, gender=MALE, age=20]
//				, Paula_32=Person [name=Paula, gender=FEMALE, age=32]
//				, Jack_20=Person [name=Jack, gender=MALE, age=20]
//				, Sara_22=Person [name=Sara, gender=FEMALE, age=22]
//				, Paul_32=Person [name=Paul, gender=MALE, age=32]
//				, Jack_2=Person [name=Jack, gender=MALE, age=2]
//				, Sara_20=Person [name=Sara, gender=FEMALE, age=20]
//				, Jill_12=Person [name=Jill, gender=FEMALE, age=12]
//				}

		//grouping person by their names and list of ages for same names 
		System.out.println(people
				.stream()
				.collect(Collectors.groupingBy(
						Person::getName,
						Collectors.mapping(
								Person::getAge,
								Collectors.toList()))));

		// output
		// {Bob=[20], Sara=[20, 22], Jill=[12], Jack=[2, 20], Paula=[32], Paul=[32]}

	}

}

class Person {
	String name;
	Gender gender;
	int age;

	public Person(String name, Gender gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]\n";
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

}

enum Gender {
	MALE, FEMALE
}
