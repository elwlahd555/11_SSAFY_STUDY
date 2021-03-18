package com.test.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 전원연결 {
	private static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=sc.nextInt();
			int arr[][]=new int[N][N];
			int core=0;
			int resultcore=0;
			ArrayList<Point>arrlist=new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]=sc.nextInt();
					if((i==0||j==0)&&arr[i][j]==1) {
						core++;
						resultcore++;
					}else if(arr[i][j]==1) {
						core++;
						arrlist.add(new Point(i,j));
					}
				}	
			}
			for (int i = 0; i < arrlist.size(); i++) {
				Point p=arrlist.get(i);
				
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
