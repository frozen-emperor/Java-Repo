package com.generics;

public class GenericDemo_1 {

	public static void main(String[] args) {
		Gen<Integer> genericObjInteger = new Gen<Integer>(88);
		// Gen<Integer> genericObjInteger_2 = new Gen<Integer>(88.00); !!constructor
		// undefinec CE

		genericObjInteger.showType();
		int val = genericObjInteger.getObj(); // auto unboxing
		System.out.println(val);

		Gen<String> genericObjectString = new Gen<String>("shailesh");
		genericObjectString.showType();
		String str = genericObjectString.getObj();
		System.out.println(str);

		// genericObjectString = genericObjInteger; //type mismatch
		// generic ensures type safety at compile time itself

		NonGen nonGenInt = new NonGen(Integer.valueOf(88));
		nonGenInt.showType();
		int valNonGenInt = (Integer) nonGenInt.getObj(); // explicit cast will be needed
		System.out.println(valNonGenInt);
		
		NonGen nonGenString =  new NonGen(String.valueOf("shailesh"));
		nonGenString.showType();
		String valNonGenString = (String) nonGenString.getObj(); // explicit cast will be needed
		System.out.println(valNonGenString);
		
		valNonGenInt = (Integer) nonGenString.getObj(); //compiles fine but conceptually wrong
		//class cast exception runtime
		System.out.println(valNonGenInt);
	}

}

class Gen<T> {
	T o;

	public Gen(T o) {
		this.o = o;
	}

	public void showType() {
		System.out.println(o.getClass());
	}

	public T getObj() {
		return o;
	}
}

class NonGen {
	Object o;

	public NonGen(Object o) {
		this.o = o;
	}

	public void showType() {
		System.out.println(o.getClass());
	}

	public Object getObj() {
		return o;
	}
}