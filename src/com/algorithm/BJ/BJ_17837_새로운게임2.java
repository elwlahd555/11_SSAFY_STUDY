package com.algorithm.BJ;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ_17837_새로운게임2 {
	static class Point{
		int x,y,move,floor;

		public Point(int x, int y, int move, int floor) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.floor = floor;
		}


		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int arr[][]=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j]=sc.nextInt();
				
			}
		}

		LinkedList<Point> que=new LinkedList<Point>();
		for (int i = 0; i < K; i++) {
			que.add(new Point(sc.nextInt(),sc.nextInt(),sc.nextInt(),0));
		}
		while(true) {
			for (int i = 0; i < N; i++) {
				Point p=que.get(i);
				if(p.floor>0)continue;
				switch (p.move) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;

				}
			}
		}
	}

}
