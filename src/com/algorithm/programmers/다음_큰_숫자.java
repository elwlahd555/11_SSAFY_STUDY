package com.algorithm.programmers;

public class 다음_큰_숫자 {
	public static void main(String[] args) {
		int answer = solution(78);
		System.out.println(answer);

	}

	private static int solution(int n) {
		int answer = 0;
		int temp = Integer.bitCount(n);
		while (true) {
			if (Integer.bitCount(++n) == temp) {
				answer = n;
				break;
			}
		}
		return answer;
	}
}
