package com.test.ssafy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 전원연결 {

	static int N;
	static int arr[][];
	static int temp[];
	static boolean visited[];

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			N = sc.nextInt();
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			List<Point> arrlist = new ArrayList<>();

			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					if (arr[i][j] == 1) {
						arrlist.add(new Point(i, j));
					}
				}

			}
			temp = new int[arrlist.size()];
			visited = new boolean[arrlist.size()];
			find(0, arrlist);
			System.out.println("#"+t+" "+result);
		}

	}

	static int result = Integer.MAX_VALUE;
	static int coreresult = 0;

	private static void find(int cnt, List<Point> arrlist) {

		// TODO Auto-generated method stub
		if (cnt == arrlist.size()) {
			int temptemparr[][] = new int[N][N];
			for (int i = 0; i < temptemparr.length; i++) {
				temptemparr[i]=Arrays.copyOf(arr[i], arr[i].length);
			}

			solve(arrlist, temptemparr);
			int core=0;
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temptemparr[i][j] == 2) {
						count++;
					}
					if(temptemparr[i][j]==1) {
						core++;
					}
				}
			}
			if(coreresult<core) {
				coreresult=core;
				result = count;
			}else if(coreresult==core) {
				result = Math.min(result, count);
				
			}
			return;
		}

		for (int i = 0; i < arrlist.size(); i++) {
			if (visited[i])
				continue;
			temp[cnt] = i;
			visited[i] = true;
			find(cnt + 1, arrlist);
			visited[i] = false;
		}
	}

	private static void solve(List<Point> arrlist, int nono[][]) {
		// TODO Auto-generated method stub
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		for (int i = 0; i < arrlist.size(); i++) {
			Point p = arrlist.get(temp[i]);
			int arrtemp[] = new int[4];
			for (int k = 0; k < 4; k++) {
				int x = p.x;
				int y = p.y;
				int count = 0;
				while (true) {
					x += dx[k];
					y += dy[k];
					if (nono[x][y] != 0) {
						count = 0;
						break;

					} else if (nono[x][y] == 0) {
						count++;
						if (x == 0 || x == N - 1 || y == 0 || y == N - 1) {
							break;
						}
						continue;
					}
				}

				arrtemp[k] = count;
			}
			int k = Integer.MAX_VALUE;
			for (int j = 0; j < 4; j++) {
				if (arrtemp[j] > 0) {
					k = Math.min(k, arrtemp[j]);

				}
			}

			if (k == Integer.MAX_VALUE) {
				nono[p.x][p.y]=3;
			}else {
				
				for (int j = 0; j < 4;j++) {
					if(k==arrtemp[j]) {
						
						int xx = p.x + dx[j];
						int yy = p.y + dy[j];
						for (int j2 = 0; j2 < k; j2++) {
							
							nono[xx][yy] = 2;
							xx += dx[j];
							yy += dy[j];
							
						}
						break;
					}
					
				}
			}
				
		}
	}

}
/*
1
7
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0
 */
