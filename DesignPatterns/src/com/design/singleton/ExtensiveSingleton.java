package com.design.singleton;

import java.util.HashSet;
import java.util.Set;

public class ExtensiveSingleton {

	public static void main(String[] args) {
		try {
			ParentSingleton parentSingleton = new ParentSingleton();
			ParentSingleton parentSingleton2 = new ParentSingleton();
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ChildSingleton  childSingleton1 = new ChildSingleton();
			ChildSingleton  childSingleton2 = new ChildSingleton();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

class ParentSingleton {

	private static final Set<Class<? extends ParentSingleton>> classTypeInstantiated = new HashSet<>();

	public ParentSingleton() throws Exception {
		if (classTypeInstantiated.contains(this.getClass())) {
			throw new Exception("Exception : this class was already instantiated once!!");
		}

		classTypeInstantiated.add(this.getClass());
		System.out.println("First Instance created");
	}

}

class ChildSingleton extends ParentSingleton{

	public ChildSingleton() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}}
class ChildSingletonTwo extends ChildSingleton{

	public ChildSingletonTwo() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}}
class ChildSingletonThree extends ParentSingleton{

	public ChildSingletonThree() throws Exception{
		super();
		// TODO Auto-generated constructor stub
	}}
