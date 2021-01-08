package com.ssafy.programmers;

public class 내적 {
	public static void main(String[] args) {
		int[] a= {1,2,3,4};
		int[] b= {-3,-1,0,2};
		
		int answer=0;
		
		for (int i = 0; i < b.length; i++) {
			answer+=a[i]*b[i];
		}
		System.out.println(answer);
	}
}
