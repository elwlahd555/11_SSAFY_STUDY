package com.algorithm.programmers;

import java.util.LinkedList;

public class 프린터 {
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		int[] priorities= {2,1,3,2};
		int location=2;
		int answer=0;
		
		LinkedList<Point> que=new LinkedList<Point>();
		
		for (int i = 0; i < priorities.length; i++) {
			que.add(new Point(i,priorities[i]));
		}
		while(true) {
			Point p=que.get(0);
			int size=que.size();
			for (int i = 0; i < size; i++) {
				if(p.y<que.get(i).y) {
					que.poll();
					que.add(p);
					break;
				}
			}
			Point temp;
			if(p.equals(que.get(0))) {
				answer++;
				temp=que.poll();
				if(temp.x==location) {
					System.out.println(answer);
					break;
				}
			}
		}
		
	}
}
