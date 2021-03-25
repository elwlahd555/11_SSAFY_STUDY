package com.algorithm.SWEA;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_8382_방향전환 {
	private static class Point{
		int x,y,type,count;

		public Point(int x, int y,int type) {
			super();
			this.x = x;
			this.y = y;
			this.type=type;
		}

		public Point(int x, int y, int type, int count) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.count = count;
		}
		
	}
	private static int dx[]= {-1,1,0,0};
	private static int dy[]= {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			Point start=new Point(sc.nextInt(),sc.nextInt(),0);
			Point finish=new Point(sc.nextInt(),sc.nextInt(),0);
			LinkedList<Point> que=new LinkedList<Point>();
			que.add(start);
			int count=0;
			outer:
			while(!que.isEmpty()) {
				int size=que.size();
				for (int i = 0; i < size; i++) {
					Point p=que.poll();
					
					if(finish.x==p.x&&finish.y==p.y) {
						break outer;
					}
					for (int k = 0; k < 4; k++) {
						int x=p.x+dx[k];
						int y=p.y+dy[k];
						int type=p.type;
						Point temp=new Point(x,y,type);
						temp.count=count;
						if(k<2&&(type==0||type==2)) {
							temp.type=1;
							que.add(temp);
						}else if(k>=2&&(type==0||type==1)) {
							temp.type=2;
							que.add(temp);
							
						}
						
					}
				}
				count++;
			}
			System.out.println("#"+t+" "+count);
		}
	}
}
