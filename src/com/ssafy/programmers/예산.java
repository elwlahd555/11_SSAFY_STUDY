package com.ssafy.programmers;

import java.util.Arrays;

public class 예산 {
	public static void main(String[] args) {
		int[] d= {1,3,2,5,4};
		Arrays.sort(d);
		int budget=9;
		int answer = 0;
		
		for (int i = 0; i < d.length; i++) {
			
			if(budget>=d[i]) {
				budget-=d[i];
				answer++;
			}else break;
		}
		System.out.println(answer);
	}
}
