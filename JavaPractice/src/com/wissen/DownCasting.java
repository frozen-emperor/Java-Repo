package com.wissen;

public class DownCasting {

	public static void main(String[] args) {
		A a = new B();
		a.xyz();
		
		B b =(B) new A();
		//needs casting
	}

}
class A{

	public A() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void xyz() {
		System.out.println("xyz from A");
	}
}

class B extends A{
	
	int i;

	public B() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void xyz() {
		System.out.println("xyz from B");
	}
}
