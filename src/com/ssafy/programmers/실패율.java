package com.ssafy.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 실패율 {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] answer = new int[N];
		double[] temp = new double[N + 1];
		ArrayList<Stage> arrlist = new ArrayList<Stage>();

		int size = stages.length;
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] <= N) {
				temp[stages[i]]++;
			} else
				continue;
		}

		for (int i = 1; i <= N; i++) {
			double k = temp[i];
			if (size == 0) {

				temp[i] = 0;
			} else {

				temp[i] /= size;
			}
			size -= k;

			arrlist.add(new Stage(i, temp[i]));

		}
		arrlist.sort(Stage::compareTo);
		for (int i = 0; i < arrlist.size(); i++) {
			answer[i] = arrlist.get(i).stage;
		}
		System.out.println(Arrays.toString(answer));

	}

	private static class Stage implements Comparable<Stage> {
		int stage;
		double failure;

		public Stage(int stage, double failure) {
			super();
			this.stage = stage;
			this.failure = failure;
		}

		@Override
		public int compareTo(Stage o) {
			if (this.failure == o.failure) {
				return this.stage < o.stage ? -1 : 1;
			} else {

				return this.failure > o.failure ? -1 : 1;
			}
		}

	}
}
