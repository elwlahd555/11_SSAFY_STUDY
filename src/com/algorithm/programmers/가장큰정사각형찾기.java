package com.algorithm.programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 가장큰정사각형찾기 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		int board[][] = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };

		int dx[] = { 1, 0, 1 };
		int dy[] = { 0, 1, 1 };
		int answer = 1;
		int N = board.length;
		int M = board[0].length;
		boolean visit[][] = new boolean[N][M];
		LinkedList<Point> que = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(i+answer>=N||j+answer>=M)continue;
				else if (board[i][j] == 1) {
					int temp = 1;
					que.add(new Point(i, j));
					outer: while (!que.isEmpty()) {
						int size = que.size();

						for (int k = 0; k < size; k++) {
							Point p = que.poll();
							for (int c = 0; c < 3; c++) {
								int x = p.x + dx[c];
								int y = p.y + dy[c];
								if ( x < N && y < M &&!visit[x][y] && board[x][y] == 1) {
									que.add(new Point(x, y));
									visit[x][y] = true;
								} else if(x >= N || y >= M || board[x][y] == 0){
									
									for (int l = 0; l < N; l++) {
										Arrays.fill(visit[l], false);
									}
									while (!que.isEmpty()) {
										que.poll();
									}
									break outer;
								}
							}

						}
						temp++;
					}
					answer = Integer.max(answer, temp);
				}

			}
		}
		if(answer==1) {
			answer=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(board[i][j]==1) {
						answer=1;
					}
				}
			}
			
		}
		System.out.println(answer * answer);

	}
}
