package com.algorithm.programmers;

import java.math.BigInteger;
import java.util.Arrays;

public class 최대공약수와최소공배수 {
	public static void main(String[] args) {
		int n=3;
		int m=12;
		int[] answer=new int[2];
		BigInteger N=new BigInteger(String.valueOf(n));
		BigInteger M=new BigInteger(String.valueOf(m));
		answer[0]=N.gcd(M).intValue();
		answer[1]=N.multiply(M).intValue()/answer[0];
		System.out.println(Arrays.toString(answer));
	}
}
