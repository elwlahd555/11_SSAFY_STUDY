package com.ssafy.study;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_1953_탈주범검거 {
	private static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	private static int N,M;
	private static int arr[][];
	private static boolean visit[][];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			int R=sc.nextInt();
			int C=sc.nextInt();
			int L=sc.nextInt();
			arr=new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j]=sc.nextInt();
				}
				
			}
			visit=new boolean[N][M];
			LinkedList<Point> que=new LinkedList<Point>();
			que.add(new Point(R,C));
			visit[R][C]=true;
			int count=1;
			while(!que.isEmpty()&&L>count) {
				int size=que.size();
				for (int i = 0; i < size; i++) {
					Point p=que.poll();
					Point temp=new Point(-1,-1);
					switch(arr[p.x][p.y]) {
					case 1:
						temp=left(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=right(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=up(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=down(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						break;
					case 2:
						temp=up(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=down(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						break;
					case 3:
						temp=left(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=right(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						break;
					case 4:
						temp=up(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=right(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						break;
					case 5:
						temp=right(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=down(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						break;
					case 6:
						temp=left(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=down(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						break;
					case 7:
						temp=left(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						temp=up(p.x,p.y);
						if(temp.x>=0) {
							que.add(temp);
							visit[temp.x][temp.y]=true;
						}
						break;
					}
					
				}
				count++;
			}
			int result=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visit[i][j])result++;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
	private static Point down(int x, int y) {
		// TODO Auto-generated method stub
		int a=x+1;
		int b=y;
		if(a>=0&&a<N&&b>=0&&b<M&&!visit[a][b]&&(arr[a][b]==1||arr[a][b]==2||arr[a][b]==4||arr[a][b]==7)) {
			
			return new Point(a,b);
		}else {
			
			return new Point(-1,-1);
		}
	}
	private static Point up(int x, int y) {
		// TODO Auto-generated method stub
		int a=x-1;
		int b=y;
		if(a>=0&&a<N&&b>=0&&b<M&&!visit[a][b]&&(arr[a][b]==1||arr[a][b]==2||arr[a][b]==5||arr[a][b]==6)) {
			
			return new Point(a,b);
		}else {
			
			return new Point(-1,-1);
		}
	}
	private static Point right(int x, int y) {
		// TODO Auto-generated method stub
		int a=x;
		int b=y+1;
		if(a>=0&&a<N&&b>=0&&b<M&&!visit[a][b]&&(arr[a][b]==1||arr[a][b]==3||arr[a][b]==6||arr[a][b]==7)) {
			
			return new Point(a,b);
		}else {
			
			return new Point(-1,-1);
		}
	}
	private static Point left(int x, int y) {
		// TODO Auto-generated method stub
		int a=x;
		int b=y-1;
		if(a>=0&&a<N&&b>=0&&b<M&&!visit[a][b]&&(arr[a][b]==1||arr[a][b]==3||arr[a][b]==4||arr[a][b]==5)) {
			
			return new Point(a,b);
		}else {
			
			return new Point(-1,-1);
		}
	}
}
