package com.algorithm.programmers;

public class 정수제곱근판별 {
	public static void main(String[] args) {
		long n=121;
		int temp=(int) Math.sqrt(n);
		long answer=0;
		if(n==Math.pow(temp, 2)) {
			answer=(long) Math.pow(temp+1, 2);
		}else {
			answer=-1;
		}
		System.out.println(answer);
	}
}
