package com.generics;

public class GenericDemo_2_TwoGen {

	public static void main(String[] args) {
		TwoGen<String, Integer> stringAndIntTwoGen = new TwoGen<>("shailesh", 123);

		stringAndIntTwoGen.showType();
		// int i = stringAndIntTwoGen.getT(); auto type checking at cmpile time
		String str = stringAndIntTwoGen.getT();
		int i = stringAndIntTwoGen.getV();
		System.out.println(str + "-" + i);
	}

}

class TwoGen<T, V> {
	T t;
	V v;

	public TwoGen(T t, V v) {
		this.t = t;
		this.v = v;
	}

	public void showType() {
		System.out.println(t.getClass() + " and " + v.getClass());
	}

	public T getT() {
		return t;
	}

	public V getV() {
		return v;
	}
}
