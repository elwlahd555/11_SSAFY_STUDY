package com.algorithm.programmers;

import java.util.Arrays;

public class 평균구하기 {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4};
		
		double answer=0;
		
		answer=Arrays.stream(arr).average().getAsDouble();
		
		System.out.println(answer);
	}
}
