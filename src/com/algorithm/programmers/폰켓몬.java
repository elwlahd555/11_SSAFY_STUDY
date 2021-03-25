package com.algorithm.programmers;

import java.util.HashSet;

public class 폰켓몬 {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 3 };

		HashSet<Integer> set = new HashSet<Integer>();

		for (Integer i : nums) {
			set.add(i);
		}
		int answer = nums.length / 2;

		if (answer > set.size()) {
			answer = set.size();
		}
		System.out.println(answer);
	}

}
