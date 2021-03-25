package com.algorithm.programmers;

import java.util.Arrays;

public class 소수찾기 {
	public static void main(String[] args) {
		int n=5;
		int answer=0;
		boolean []sosu=new boolean[n+1];
		Arrays.fill(sosu, true);
		int root=(int)Math.sqrt(n);
		for (int i = 2; i <= root; i++) {
			if(sosu[i]==true) {
				for (int j = i; i*j <= n; j++) {
					sosu[i*j]=false;
				}
			}
			
		}
		for (int i = 2; i <=n; i++) {
			if(sosu[i]==true) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
