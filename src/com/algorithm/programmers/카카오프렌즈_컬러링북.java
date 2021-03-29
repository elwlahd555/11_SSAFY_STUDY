package com.algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 카카오프렌즈_컬러링북 {
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		long[][] picture = { {0,1,0},{1,1,0},{0,0,0}};
		long[][]temparr=new long[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				temparr[i][j]=picture[i][j];
			}
		}
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		LinkedList<Point> que = new LinkedList<Point>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (temparr[i][j] > 0) {
					long temp = temparr[i][j];
					int maxsize = 1;
					numberOfArea++;
					temparr[i][j] = 0;
					que.add(new Point(i, j));
					while (!que.isEmpty()) {
						Point p = que.poll();
						for (int k = 0; k < 4; k++) {
							int px = p.x + dx[k];
							int py = p.y + dy[k];
							if (px >= 0 && px < m && py >= 0 && py < n && temparr[px][py] == temp) {
								que.add(new Point(px, py));
								temparr[px][py] = 0;
								maxsize++;
							}
						}
					}
					if (maxSizeOfOneArea < maxsize) {
						maxSizeOfOneArea = maxsize;
					}
				}
			}
		}

		System.out.println(numberOfArea + " " + maxSizeOfOneArea);

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
	}
}
