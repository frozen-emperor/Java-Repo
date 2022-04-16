package com.wissen;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImmutableEmployeeClass {

	/**
	 * for reference, look here: <a href="https://www.javainuse.com/misc/immutable-interview-questions">Google</a>
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		//
		List<String> roles = new ArrayList<String>();
		roles.add("dev");
		Employee e1 = new Employee(0, "shailesh", roles);
		System.out.println(e1);//Employee [id=0, name=shailesh, roles=[dev]]
		
		e1.getRoles().add("new respo");//this will not change since deep cloned object is returned
		System.out.println(e1);//Employee [id=0, name=shailesh, roles=[dev]]
		
		Employee e2  = e1.getClone();
		System.out.println(e2==e1);
	}

}

class Employee implements Cloneable{
	private final int id;
	private final String name;
	private final List<String> roles;

	public Employee(int id, String name, List<String> roles) {
		super();
		this.id = id;
		this.name = name;
		this.roles = new ArrayList<String>(roles);//to avoid changes due to external manipluation of the passed reff
	}

	public Employee getClone() throws CloneNotSupportedException {
		return (Employee) this.clone();
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getRoles() {
		return new ArrayList<String>(roles);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", roles=" + roles + "]";
	}

//	@Override
//	public int hashCode() {
////		return Objects.hash(id, name, roles);
//		return 1;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(roles, other.roles);
	}
	
	

}