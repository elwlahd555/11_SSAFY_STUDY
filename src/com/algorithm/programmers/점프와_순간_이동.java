package com.algorithm.programmers;

public class 점프와_순간_이동 {
	public static void main(String[] args) {
		int answer = solution(5);
		System.out.println(answer);
	}

	private static int solution(int n) {

		int ans = 0;
		while (n != 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n--;
				ans++;
			}
		}
		return ans;
	}
}
