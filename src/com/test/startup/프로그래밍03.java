package com.test.startup;

import java.util.LinkedList;

public class 프로그래밍03 {
	public static void main(String[] args) {
		int[][] maps= {{1, 28, 41, 22, 25, 79, 4}, {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19}, {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29},{39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}};
		int p=19;
		int r=6;
		int answer=solution(maps,p,r);
	}
	private static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	private static int solution(int[][] maps, int p, int r) {
		int dx[]= {-1,1,0,0};
		int dy[]= {0,0,-1,0};
		for (int i = 1; i < maps.length; i++) {
			for (int j = 1; j < maps.length; j++) {
				LinkedList<Point> list=new LinkedList<>();
				list.add(new Point(i-1,j-1));
				list.add(new Point(i,j-1));
				list.add(new Point(i-1,j));
				list.add(new Point(i,j));
				int temp=r/2;
				while(!list.isEmpty()) {
				}
			}
		}
		
		return 0;
	}
}
