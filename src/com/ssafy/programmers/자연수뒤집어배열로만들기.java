package com.ssafy.programmers;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
	public static void main(String[] args) {
		long n=12345;
		String s=String.valueOf(n);
		int[] answer = new int[s.length()];
		for (int i = 0; i < answer.length; i++) {
			answer[i]=s.charAt(answer.length-i-1)-'0';
		}
		System.out.println(Arrays.toString(answer));
	}
}
