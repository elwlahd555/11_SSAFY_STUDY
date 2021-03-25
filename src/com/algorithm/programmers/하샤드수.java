package com.algorithm.programmers;

import java.util.Arrays;

public class 하샤드수 {
	public static void main(String[] args) {
		int x=11;
		boolean answer = true;
		String s=String.valueOf(x);
		int arr[]=new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i]=s.charAt(i)-'0';
		}
		int sum=Arrays.stream(arr).sum();
		if(x%sum==0) {
			answer=true;
		}else {
			answer=false;
		}
		System.out.println(answer);
	}
}
