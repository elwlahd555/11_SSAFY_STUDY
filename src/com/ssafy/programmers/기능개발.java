package com.ssafy.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 기능개발 {
	public static void main(String[] args) {
		int[] progresses = { 95, 90, 99, 99, 80, 99 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };
		int[] answer = {};

		int cnt = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		outer: while (cnt < progresses.length) {
			if (progresses[cnt] >= 100) {
				int temp = 0;
				for (int i = cnt; i < progresses.length; i++) {
					temp++;
					cnt++;
					if (cnt < progresses.length && progresses[cnt] < 100) {
						arr.add(temp);
						break;
					} else if (cnt == progresses.length) {
						arr.add(temp);
						break outer;
					}
				}
			}
			for (int i = 0; i < progresses.length; i++) {
				progresses[i] += speeds[i];
			}
		}
		answer = new int[arr.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}
		System.out.println(Arrays.toString(answer));
	}
}
