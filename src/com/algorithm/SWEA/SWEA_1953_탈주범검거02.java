package com.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거02 {
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int N, M;
	private static int arr[][];
	private static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int answer = 0;
			visited = new boolean[N][M];
			arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			LinkedList<Point> que = new LinkedList<Point>();
			que.add(new Point(R, C));
			visited[R][C] = true;
			while (!que.isEmpty() && L > 1) {
				int size = que.size();
				L--;
				for (int k = 0; k < size; k++) {
					Point p = que.poll();
					switch (arr[p.x][p.y]) {
					case 1:
						if (up(p.x - 1, p.y)) {
							que.add(new Point(p.x - 1, p.y));
							visited[p.x - 1][p.y] = true;
						}
						if (down(p.x + 1, p.y)) {
							que.add(new Point(p.x + 1, p.y));
							visited[p.x + 1][p.y] = true;
						}
						if (left(p.x, p.y - 1)) {
							que.add(new Point(p.x, p.y - 1));
							visited[p.x][p.y - 1] = true;
						}
						if (right(p.x, p.y + 1)) {
							que.add(new Point(p.x, p.y + 1));
							visited[p.x][p.y + 1] = true;
						}
						break;
					case 2:
						if (up(p.x - 1, p.y)) {
							que.add(new Point(p.x - 1, p.y));
							visited[p.x - 1][p.y] = true;
						}
						if (down(p.x + 1, p.y)) {
							que.add(new Point(p.x + 1, p.y));
							visited[p.x + 1][p.y] = true;
						}
						break;
					case 3:
						if (left(p.x, p.y - 1)) {
							que.add(new Point(p.x, p.y - 1));
							visited[p.x][p.y - 1] = true;
						}
						if (right(p.x, p.y + 1)) {
							que.add(new Point(p.x, p.y + 1));
							visited[p.x][p.y + 1] = true;
						}
						break;
					case 4:
						if (up(p.x - 1, p.y)) {
							que.add(new Point(p.x - 1, p.y));
							visited[p.x - 1][p.y] = true;
						}
						if (right(p.x, p.y + 1)) {
							que.add(new Point(p.x, p.y + 1));
							visited[p.x][p.y + 1] = true;
						}
						break;
					case 5:
						if (down(p.x + 1, p.y)) {
							que.add(new Point(p.x + 1, p.y));
							visited[p.x + 1][p.y] = true;
						}
						if (right(p.x, p.y + 1)) {
							que.add(new Point(p.x, p.y + 1));
							visited[p.x][p.y + 1] = true;
						}
						break;
					case 6:
						if (down(p.x + 1, p.y)) {
							que.add(new Point(p.x + 1, p.y));
							visited[p.x + 1][p.y] = true;
						}
						if (left(p.x, p.y - 1)) {
							que.add(new Point(p.x, p.y - 1));
							visited[p.x][p.y - 1] = true;
						}
						break;
					case 7:
						if (left(p.x, p.y - 1)) {
							que.add(new Point(p.x, p.y - 1));
							visited[p.x][p.y - 1] = true;

						}
						if (up(p.x - 1, p.y)) {
							que.add(new Point(p.x - 1, p.y));
							visited[p.x - 1][p.y] = true;
						}
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						answer++;
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	private static boolean right(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]
				&& (arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 6 || arr[x][y] == 7)) {
			return true;
		}
		return false;
	}

	private static boolean left(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]
				&& (arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 4 || arr[x][y] == 5)) {
			return true;
		}
		return false;
	}

	private static boolean down(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]
				&& (arr[x][y] == 1 || arr[x][y] == 2 || arr[x][y] == 4 || arr[x][y] == 7)) {
			return true;
		}
		return false;
	}

	private static boolean up(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]
				&& (arr[x][y] == 1 || arr[x][y] == 2 || arr[x][y] == 5 || arr[x][y] == 6)) {
			return true;
		}
		return false;
	}
}
