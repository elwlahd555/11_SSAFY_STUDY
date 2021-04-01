package com.algorithm.programmers;

public class 큰_수_만들기 {

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		StringBuilder answer = new StringBuilder();
		int cnt = 0;
		char max = '0';
		if (number.charAt(0) == '0') {
			answer.append("0");
		}
		for (int i = 0; i < number.length() - k; i++) {
			max = '0';
			for (int j = cnt; j <= k + i; j++) {
				if (number.charAt(j) > max) {
					max = number.charAt(j);
					cnt = j + 1;

				}
			}
			answer.append(max);
		}
		System.out.println(answer);
	}
}
