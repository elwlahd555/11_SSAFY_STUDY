package com.algorithm.programmers;

import java.util.Arrays;

public class x만큼간격이있는n개의숫자 {
	public static void main(String[] args) {
		int x=2;
		int n=5;
		long[] answer=new long[n];
		for (int i = 0; i < answer.length; i++) {
			answer[i]=(long)x*(i+1);
		}
		System.out.println(Arrays.toString(answer));
	}
}
