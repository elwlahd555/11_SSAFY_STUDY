package com.algorithm.programmers;

public class 약수의_개수와_덧셈 {
	public static void main(String[] args) {
		int left = 13;
		int right = 17;
		int result = solution(left, right);
		System.out.println(result);
	}

	private static int solution(int left, int right) {
		int answer = 0;
		for (int i = left; i <= right; i++) {
			int cnt = 0;
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					cnt++;
				}
			}
			if (cnt % 2 == 1) {
				answer -= i;
			} else {
				answer += i;
			}
		}
		return answer;
	}
}
