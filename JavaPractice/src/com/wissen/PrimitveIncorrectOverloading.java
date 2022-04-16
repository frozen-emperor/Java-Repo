package com.wissen;

public class PrimitveIncorrectOverloading {

	public static void main(String[] args) {
		xyz('l');
	}

//	public static void xyz(int i) {
//		System.out.println("void int");
//	}
	
	public static int xyz(int i) {
		System.out.println("int int");
		return 0;
	}
	
	public static void xyz(char i) {
		System.out.println("void char");
	}
}
