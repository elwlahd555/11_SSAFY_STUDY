package com.algorithm.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성02 {
	private static int N, K, max, answer;
	private static int[][] map;
	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };
	private static boolean visited[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			max = 0;
			answer = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) {
						max = map[i][j];
					}
				}
			}
			find();
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void find() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == max) {

					dfs(i, j, map[i][j], false, 1);
				}
			}
		}
	}

	private static void dfs(int i, int j, int height, boolean cut, int cnt) {
		answer = Math.max(answer, cnt);
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && x < N && y >= 0 && y < N && map[x][y] < height && !visited[x][y]) {
				dfs(x, y, map[x][y], cut, cnt + 1);
			} else if (x >= 0 && x < N && y >= 0 && y < N && !cut && map[x][y] - K < height && !visited[x][y]) {
				dfs(x, y, height - 1, true, cnt + 1);
			}
		}
		visited[i][j] = false;
	}
}
