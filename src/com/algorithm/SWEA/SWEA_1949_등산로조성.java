package com.algorithm.SWEA;

import java.util.Scanner;

public class SWEA_1949_등산로조성 {
	private static int map[][];
	private static int max, N, K, top;
	private static boolean[][] visited;
	private static int dr[] = { -1, 1, 0, 0 };
	private static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0; // 최장경로 길이
			top = 0; // 봉우리 높이
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (top < map[i][j])
						top = map[i][j];
				}
			}
			findTop();
			System.out.println("#" + t + " " + max);
		}
	}

	private static void findTop() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == top)
					makeLoad(i, j, map[i][j], false, 1);
			}
		}
	}

//DFS
	private static void makeLoad(int r, int c, int height, boolean isUsed, int distance) {
		
		max=Math.max(max, distance);
		visited[r][c]=true;
		int nr, nc;
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				if (height > map[nr][nc]) { // 현위치기준으로 내리막
					makeLoad(nr, nc, map[nr][nc], isUsed, distance + 1);

				} else if (!isUsed && map[nr][nc] - K < height) { // 현위치기준으로 평지이거나 오르막 : 깎아서 갈수 있는지 체크
					makeLoad(nr, nc, height - 1, true, distance + 1);
				}
			}
		}
		visited[r][c]=false;

	}
}
