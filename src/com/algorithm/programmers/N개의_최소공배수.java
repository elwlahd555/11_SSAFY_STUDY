package com.algorithm.programmers;

import java.math.BigInteger;

public class N개의_최소공배수 {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 14 };
		int result = solution(arr);
		System.out.println(result);
	}

	private static int solution(int[] arr) {
		BigInteger a = new BigInteger(String.valueOf(arr[0]));

		for (int i = 1; i < arr.length; i++) {
			BigInteger b = new BigInteger(String.valueOf(arr[i]));
			a = a.multiply(b).divide(a.gcd(b));
		}

		return a.intValue();
	}
}
