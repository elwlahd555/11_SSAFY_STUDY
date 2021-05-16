package com.test.kakaoIntern;

import java.util.Arrays;
import java.util.LinkedList;

public class 프로그래밍02 {
	private static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		int[] answer = solution(places);
		System.out.println(Arrays.toString(answer));
	}

	private static int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int k = 0; k < 5; k++) {
			char[][] arr = new char[5][5];
			for (int i = 0; i < 5; i++) {
				arr[i] = places[k][i].toCharArray();
			}
			boolean check = true;
			outer: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (arr[i][j] == 'P') {
						if (bfs(arr, i, j)) {
							check = true;
						} else {
							check = false;
							break outer;
						}
					}
				}
			}
			answer[k] = check ? 1 : 0;
		}
		return answer;

	}

	private static boolean bfs(char[][] arr, int i, int j) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		LinkedList<Point> que = new LinkedList<>();
		que.add(new Point(i, j, 0));
		boolean[][] visited = new boolean[5][5];
		visited[i][j] = true;
		int check = 0;

		while (check < 2) {
			int size = que.size();
			for (int c = 0; c < size; c++) {
				Point p = que.poll();
				for (int k = 0; k < 4; k++) {
					int x = p.x + dx[k];
					int y = p.y + dy[k];

					if (x < 0 || x >= 5 || y < 0 || y >= 5 || visited[x][y] || arr[x][y] == 'X')
						continue;
					if (arr[x][y] == 'P') {
						return false;
					}
					que.add(new Point(x, y, p.z + 1));
					visited[x][y] = true;
				}

			}
			check++;
		}
		return true;
	}
}
