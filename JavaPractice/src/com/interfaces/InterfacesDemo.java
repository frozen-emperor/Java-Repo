package com.interfaces;

public class InterfacesDemo {
	public static void main(String[] args) {
		
	}
}
interface I1{
	default void method() {
		System.out.println("default of I1");
	}
}

interface I2{
	default void method() {
		System.out.println("default of I2");
	}
}

class A implements  I1,I2{

	@Override //if not inherited then compiler errror same method ambiguity
	public void method() {
		// TODO Auto-generated method stub
//		super.method();
	}
	
}

