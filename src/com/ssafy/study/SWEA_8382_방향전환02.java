package com.ssafy.study;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_8382_방향전환02 {

	private static class Point {
		int x, y, d, cnt; // x좌표, y좌표, 이동방향, 이동횟수

		public Point(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

	}

	private static int x1, y1, x2, y2;
	private static final int HOR = 0, VER = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			x1 = sc.nextInt() + 100;
			y1 = sc.nextInt() + 100;
			x2 = sc.nextInt() + 100;
			y2 = sc.nextInt() + 100;

			System.out.println("#" + t + " " + bfs());
		}
	}

	private static int bfs() {
		// TODO Auto-generated method stub
		LinkedList<Point> que = new LinkedList<Point>();
		boolean[][][] visited = new boolean[2][201][201];

		visited[HOR][x1][y1] = true;
		que.add(new Point(x1, y1, HOR, 0));
		visited[VER][x1][y1] = true;
		que.add(new Point(x1, y1, VER, 0));
		Point cur;
		int nx, ny;
		while (!que.isEmpty()) {
			cur = que.poll();
			if (cur.x == x2 && cur.y == y2)
				return cur.cnt;

			if (cur.d == HOR) {
				// 세로이동 처리
				nx = cur.x;
				ny = cur.y - 1;
				if (ny >= 0 && visited[VER][nx][ny]) {
					visited[VER][nx][ny] = true;
					que.add(new Point(nx, ny, VER, cur.cnt + 1));
				}
				ny = cur.y + 1;
				if (ny <= 200 && !visited[VER][nx][ny]) {
					visited[VER][nx][ny] = true;
					que.add(new Point(nx, ny, VER, cur.cnt + 1));
				}
			} else {
				// 가로이동 처리
				nx = cur.x - 1;
				ny = cur.y;
				if (nx >= 0 && !visited[HOR][nx][ny]) {
					visited[HOR][nx][ny] = true;
					que.add(new Point(nx, ny, HOR, cur.cnt + 1));
				}
				nx = cur.x + 1;
				if (nx <= 200 && !visited[HOR][nx][ny]) {
					visited[HOR][nx][ny] = true;
					que.add(new Point(nx, ny, HOR, cur.cnt + 1));
				}

			}
		}

		return 0;
	}
}
