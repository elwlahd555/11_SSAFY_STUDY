package com.ssafy.study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	private static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

	}

	private static int N, W, H, min;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int arr[][] = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			go(0, arr);
			System.out.println("#" + t + " " + min);

		}
	}

	// i번째 구슬을 떨어뜨리기
	private static void go(int cnt, int[][] map) { // 던져진 구슬의 개수, 이전 구슬까지의 2차원 배열
		// TODO Auto-generated method stub
		if (cnt == N) {
			int result = getRemain(map);
			if (min > result)
				min = result;
			return;
		}
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; c++) {
			int r = 0;
			while (r < H && map[r][c] == 0)
				++r;
			if (r == H) { // 벽돌이 없음.
				go(cnt + 1, map);
			} else {
				// 이전구슬 상태로 배열 복사하여 초기화
				copy(map, newMap);
				// 터트리기
				boom(newMap, r, c);
				// 벽돌 내리기
				down(newMap);
				// 다음 구슬 처리
				go(cnt + 1, newMap);

			}

		}

	}

	private static void boom(int[][] map, int r, int c) {
		// TODO Auto-generated method stub
		Queue<Point> que = new LinkedList<Point>();
		if (map[r][c] > 1) {
			que.offer(new Point(r, c, map[r][c]));

		}
		map[r][c] = 0; // 벽돌 제거 처리(방문처리)

		while (!que.isEmpty()) {
			Point p = que.poll(); // 벽돌 꺼내기
			if (p.cnt == 1)
				continue;

			for (int d = 0; d < 4; d++) {
				int nr = p.r, nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] != 0) {
						if (map[nr][nc] > 1) {
							que.offer(new Point(nr, nc, map[nr][nc]));

						}
						map[nr][nc] = 0;
					}

				}
			}
		}

	}

	private static void down(int[][] map) {
		// TODO Auto-generated method stub
		for (int c = 0; c < W; c++) { // 열고정
			int r = H - 1;
			while (r > 0) {
				if (map[r][c] == 0) {
					int nr = r - 1;// 직전행
					while (nr > 0 && map[nr][c] == 0)
						--nr; // 처음만나는 벽돌 찾기
					map[r][c] = map[nr][c];
					map[nr][c] = 0;
				}
				--r;
			}
		}
	}

	private static void copy(int[][] map, int[][] newMap) {
		// TODO Auto-generated method stub
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];

			}

		}
	}

	private static int getRemain(int[][] map) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] > 0)
					++count;

			}

		}
		return count;
	}
}
