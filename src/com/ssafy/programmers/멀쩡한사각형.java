package com.ssafy.programmers;

import java.math.BigInteger;

public class 멀쩡한사각형 {
	public static void main(String[] args) {
		int w=8;
		int h=12;
		long answer=0;
		BigInteger a=new BigInteger(String.valueOf(w));
		BigInteger b=new BigInteger(String.valueOf(h));
		BigInteger temp=a.multiply(b);
		
		BigInteger gcd=a.gcd(b);
		BigInteger sub=gcd.multiply((a.divide(gcd)).add(b.divide(gcd)).subtract(new BigInteger("1")));
		answer=temp.subtract(sub).longValue();
		
		System.out.println(answer);
		
	}
}
