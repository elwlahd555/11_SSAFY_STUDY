package com.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1249_보급로 {
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			int visit[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = bf.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp.charAt(j) - '0';
					visit[i][j] = Integer.MAX_VALUE;
				}
			}
			visit[0][0] = 0;
			LinkedList<Point> que = new LinkedList<Point>();
			que.add(new Point(0, 0));
			while (!que.isEmpty()) {
				Point point = que.poll();
				for (int k = 0; k < 4; k++) {
					int x = point.x + dx[k];
					int y = point.y + dy[k];
					if (x >= 0 && x < N && y >= 0 && y < N && visit[point.x][point.y] + arr[x][y] < visit[x][y]) {
						visit[x][y] = visit[point.x][point.y] + arr[x][y];
						que.add(new Point(x, y));
					}
				}
			}
			System.out.println("#" + t + " " + visit[N - 1][N - 1]);

		}
	}
}
