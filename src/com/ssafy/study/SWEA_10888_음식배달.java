package com.ssafy.study;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_10888_음식배달 {
	private static int arr[][];
	private static ArrayList<Point> temp;
	
	private static int N, count;
	private static boolean visit[];
	static class Point{
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
			N=sc.nextInt();
			arr=new int[N][N];
			count=0;
			temp=new ArrayList<Point>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]=sc.nextInt();
					if(arr[i][j]>=2) {
						temp.add(new Point(i,j));
						count++;
					}
				}
				
			}
			visit=new boolean[count];
			result=Integer.MAX_VALUE;
			dfs(0);
			System.out.println("#"+t+" "+result);
			
		}
	}
	private static int result;
	private static void dfs(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==count) {
			int tempcal=cal();
			if(result>tempcal&&tempcal>0) {
				result=tempcal;
			}
			return;
		}
		visit[cnt]=true;
		dfs(cnt+1);
		visit[cnt]=false;
		dfs(cnt+1);
	}
	private static int cal() {
		// TODO Auto-generated method stub
		int sum=0;
		for (int i = 0; i < count; i++) {
			if(visit[i]) {
				sum+=arr[temp.get(i).x][temp.get(i).y];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sumtemp=Integer.MAX_VALUE;
				if(arr[i][j]==1) {
					for (int j2 = 0; j2 < count; j2++) {
						if(visit[j2]&&sumtemp>Math.abs(temp.get(j2).x-i)+Math.abs(temp.get(j2).y-j)
					) {
							sumtemp=Math.abs(temp.get(j2).x-i)+Math.abs(temp.get(j2).y-j);
						}
					}
					sum+=sumtemp;
				}
			}
		}
		return sum;
	}
}
