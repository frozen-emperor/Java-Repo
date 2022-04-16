package com.datatype;

import java.math.BigInteger;

public class ByteArray {
	public static void main(String[] args) {
		BigInteger i = new BigInteger("515");
		for (byte b : i.toByteArray()) {
			System.out.println(b);
		}
	}
}
