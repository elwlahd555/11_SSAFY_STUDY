package com.test.gabia;

public class programming01 {
	public static void main(String[] args) {
		int n = 10;
		int answer = 0;

		if (n == 0) {
			answer = 0;
		} else {
			while (n >= 5) {
				answer += n / 5;
				n /= 5;
			}
		}
		System.out.println(answer);
	}

}
