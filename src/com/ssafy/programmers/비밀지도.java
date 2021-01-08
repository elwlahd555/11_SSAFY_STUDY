package com.ssafy.programmers;

import java.util.Arrays;

public class 비밀지도 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };
		String[] answer = new String[n];
		for (int i = 0; i < n; i++) {
			String temp1 = addZero(Integer.toBinaryString(arr1[i]),n);
			String temp2 = addZero(Integer.toBinaryString(arr2[i]),n);
			String s="";
			for (int j = 0; j < n; j++) {
				if (temp1.charAt(j) == '1' || temp2.charAt(j) == '1') {
					s=s.concat("#");

				}else {
					s=s.concat(" ");
				}
			}
			answer[i]=s;
			
		}
		System.out.println(Arrays.toString(answer));
	}

	private static String addZero(String num, int n) {
		while(num.length()<n) {
			num="0"+num;
		}
		return num;
	}
}
