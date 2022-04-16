package com.exception;

public class ExceptionHandlingBasics {

	public static void main(String[] args) {
		//checked exception : checked at compile time - like sql,filenotfound,etc
		//unchecked : occurs at runtime , subclass of runtime exception, eg. arithmaticexception
//		try {
//			int n = 1/0;
//		}catch(ArithmeticException ae|Exception e ) { <-inavlid since e is top class of ae
//			
//		}
//		1. If all the exceptions belong to the same class hierarchy,
//		we should be catching the base exception type. However, to catch each exception, it needs to be done separately in their catch blocks.
//
//		2. Single catch block can handle more than one type of exception.
//		However, the base (or ancestor) class and subclass (or descendant) exceptions can not be caught in one statement. For Example
//
//		// Not Valid as Exception is an ancestor of 
//		// NumberFormatException
//		catch(NumberFormatException | Exception ex) 
		
		
	}

}
