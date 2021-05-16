package com.test.kakaoIntern;

public class 프로그래밍01 {
	public static void main(String[] args) {
		String s="one4seveneight";
		int answer=solution(s);
	}

	private static int solution(String s) {
		String arr[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i < arr.length; i++) {
			s = s.replace(arr[i], Integer.toString(i));
		}
		return Integer.parseInt(s);
	}
}
