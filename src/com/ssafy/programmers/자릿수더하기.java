package com.ssafy.programmers;

public class 자릿수더하기 {
	public static void main(String[] args) {
		int n=123;
		int answer=0;
		while(n!=0) {
			answer+=n%10;
			n/=10;
		}
		System.out.println(answer);
	}
}
