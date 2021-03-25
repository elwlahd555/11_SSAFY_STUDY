package com.algorithm.programmers;

import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치하기 {
	public static void main(String[] args) {
		long n=118372;
		long answer=0;
		String s=String.valueOf(n);
		String temp="";
		Character arr[]=new Character[s.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]=s.charAt(i);
		}
		Arrays.sort(arr, Collections.reverseOrder());
		
		for (int i = 0; i < arr.length; i++) {
			temp=temp.concat(String.valueOf(arr[i]));
		}
		answer=Long.parseLong(temp);
		System.out.println(answer);
	}
}
