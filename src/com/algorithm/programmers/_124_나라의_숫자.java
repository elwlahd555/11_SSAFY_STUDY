package com.algorithm.programmers;

public class _124_나라의_숫자 {
	public static void main(String[] args) {
		int n = 12;
		String answer = "";
		String[] number = { "4", "1", "2" };
		while (n > 0) {
			int temp = n % 3;
			n /= 3;
			if (temp == 0)
				n--;

			answer = number[temp] + answer;

		}
		System.out.println(answer);
	}

}
