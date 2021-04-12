package com.test.kakaocommerce;

import java.util.LinkedList;

public class programming03 {
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		int n = 6;
		int[] passenger = { 2, 1, 2, 2 };
		int[][] train = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
		int[] answer = new int[2];
		LinkedList<Point> move = new LinkedList<Point>();
		move.add(new Point(1, passenger[0]));
		while (!move.isEmpty()) {
			Point station = move.poll();
			for (int i = 0; i < train.length; i++) {
				if (station.x == train[i][0]) {
					move.add(new Point(train[i][1], station.y + passenger[train[i][1] - 1]));

				}
			}
			if (answer[1] < station.y) {
				answer[1] = station.y;
				answer[0] = station.x;
			} else if (answer[1] == station.y && answer[0] < station.x) {
				answer[0] = station.x;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);

	}
}
