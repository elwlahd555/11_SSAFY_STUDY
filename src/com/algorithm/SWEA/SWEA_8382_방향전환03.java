package com.algorithm.SWEA;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_8382_방향전환03 {

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
	private static int[][][]dir= {
			{{-1,0},{1,0}},	//hor : 0
			{{0,-1},{0,1}}	//ver : 1
	};

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
			int[][]d=dir[cur.d^1];
			for (int i = 0; i < d.length; i++) {
				nx=cur.x+d[i][0];
				ny=cur.y+d[i][1];
				if(nx>=0 && nx<=200 && ny>=0 &&ny<=200 && !visited[cur.d^1][nx][ny]) {
					visited[cur.d^1][nx][ny]=true;
					que.add(new Point(nx,ny,cur.d^1,cur.cnt+1));
				}
			}
			
		}

		return 0;
	}
}
