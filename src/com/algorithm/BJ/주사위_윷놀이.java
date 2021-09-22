package com.algorithm.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_윷놀이 {
	private static int dice[];
	private static int ans;
	private static boolean visited[][];
	private static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		for (int i = 0; i < dice.length; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		map = new int[4][30];
		map[0] = new int[] { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, -1, -1, -1,
				-1, -1, -1, -1 };
		map[1] = new int[] { 0, 0, 0, 0, 0, 10, 13, 16, 19, 25, 30, 35, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1, -1 };
		map[2] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 22, 24, 25, 30, 35, 40, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, -1, -1 };
		map[3] = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 28, 27, 26, 25, 30, 35, 40, -1, -1, -1,
				-1, -1 };

		visited = new boolean[4][30];
		visited[0][0] = true;
		check(0, new int[4], new int[4], 0);
		System.out.println(ans);
	}

	private static void check(int cnt, int[] X, int[] Y, int score) {
		if (cnt == 10) {
			ans = score > ans ? score : ans;
			return;
		}
		// 이동하기전
		for (int i = 0; i < 4; i++) {
			int x = X[i];
			int y = Y[i];
			if (map[x][y] == -1) {
				continue;
			}
			visited[x][y] = false;
			int a = 0;
			if (x == 0) {
				switch (y) {
				case 5:
					a = 1;
					break;
				case 10:
					a = 2;
					break;
				case 15:
					a = 3;
					break;
				}
			}
			// 이동한 후
			X[i]+=a;
			Y[i]+=dice[cnt];
			int m= map[X[i]][Y[i]];
			if(X[i]!=0) {
				switch(m) {
				case 40:
					X[i]=0;
					Y[i]=20;
					break;
				case 25:
					X[i]=1;
					Y[i]=9;
					break;
				case 30:
					X[i]=1;
					Y[i]=10;
					break;
				case 35:
					X[i]=1;
					Y[i]=11;
					break;
				}
			}
			if(!visited[X[i]][Y[i]]) {
				if(m!=-1) {
					visited[X[i]][Y[i]]=true;
					check(cnt+1,X,Y,score+m);
					visited[X[i]][Y[i]]=false;
				}else {
					check(cnt+1,X,Y,score);
				}
			}
			X[i]=x;
			Y[i]=y;
			visited[X[i]][Y[i]]=true;
		}
	}

}
