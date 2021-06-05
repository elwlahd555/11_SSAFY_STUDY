package com.algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 로또의_최고_순위와_최저_순위 {
	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		int result[] = solution(lottos, win_nums);
		System.out.println(Arrays.toString(result));

	}

	private static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		LinkedList<Integer> temp = new LinkedList<Integer>();
		for (int i = 0; i < win_nums.length; i++) {
			temp.add(win_nums[i]);
		}
		int lose = 7;
		int zero = 0;
		for (int i = 0; i < lottos.length; i++) {
			if (temp.contains(lottos[i])) {
				lose--;
			}
			if (lottos[i] == 0) {
				zero++;
			}
		}
		answer[0] = lose - zero;
		answer[1] = lose;
		if (answer[0] == 7) {
			answer[0] = 6;
		}
		if (answer[1] == 7) {
			answer[1] = 6;
		}
		return answer;
	}
}
