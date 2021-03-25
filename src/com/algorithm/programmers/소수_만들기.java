package com.algorithm.programmers;

public class 소수_만들기 {
	private static int answer;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		find(0, 0, nums, 0);
		System.out.println(answer);
	}

	private static void find(int cnt, int start, int nums[], int result) {
		if (cnt == 3) {
			if (check(result)) {
				answer++;
			}
			return;
		}
		for (int i = start; i < nums.length; i++) {
			result += nums[i];
			find(cnt + 1, i + 1, nums, result);
			result -= nums[i];
		}
	}

	private static boolean check(int result) {
		for (int i = 2; i < result / 2; i++) {
			if (result % i == 0) {
				return false;
			}
		}
		return true;
	}

}
