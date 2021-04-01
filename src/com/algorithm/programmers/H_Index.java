package com.algorithm.programmers;

import java.util.Arrays;
import java.util.Collections;

public class H_Index {
	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		int N = citations.length;
		Integer[] temp = new Integer[N];
		for (int i = 0; i < N; i++) {
			temp[i] = citations[i];
		}
		int answer = 0;
		Arrays.sort(temp, Collections.reverseOrder());

		while (answer < N) {
			if (temp[answer] <= answer)
				break;
			answer++;
		}
		System.out.println(answer);
	}
}