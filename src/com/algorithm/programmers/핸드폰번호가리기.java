package com.algorithm.programmers;

public class 핸드폰번호가리기 {
	public static void main(String[] args) {
		String phone_number="01033334444";
		String answer = "";
		
		char arr[]=phone_number.toCharArray();
		
		for (int i = 0; i < arr.length-4; i++) {
			arr[i]='*';
		}
		answer=String.copyValueOf(arr);
		System.out.println(answer);
	}
}
