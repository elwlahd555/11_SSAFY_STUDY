package com.study.java;

import java.util.ArrayList;
import java.util.Random;

public class random_array {
	static class Point{
		int index,value;

		public Point(int index, int value) {
			super();
			this.index = index;
			this.value = value;
		}
		
	}
	public static void main(String[] args) {
		int N=13;
		int M=20;
		int reject=50;
		int PerRejectX=reject/(N-2)+1;
		int PerRejectY=reject/(M-2)+1;
		int arr[][]= {{1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,0,1,1,1},{1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,0,1,1,1},{1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1},{1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,0,0,1,0,1},{1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1},{1,0,1,0,1,0,1,1,1,0,1,1,0,0,1,0,0,1,1,1},{1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,1,1,1},{0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1},{1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,0,1,0,1},{1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
		ArrayList<Point>X=new ArrayList<Point>();
		ArrayList<Point>Y=new ArrayList<Point>();
		for (int i = 1; i < N-1; i++) {
			int cnt=0;
			for (int j = 1; j < M-1; j++) {
				if(arr[i][j]==1) {
					cnt++;
				}
			}
			if(cnt>PerRejectX) {
				X.add(new Point(i,PerRejectX));
			}else {
				X.add(new Point(i,cnt));
			}
		}
		for (int i = 1; i < M-1; i++) {
			int cnt=0;
			for (int j = 1; j < N-1; j++) {
				if(arr[j][i]==1) {
					cnt++;
				}
			}
			if(cnt>PerRejectY) {
				Y.add(new Point(i,PerRejectY));
			}else {
				Y.add(new Point(i,cnt));
			}
		}
		Random rd=new Random();
		int num=0;
		while(reject!=0) {
			int nextX=rd.nextInt(X.size()-1);
			int nextY=rd.nextInt(Y.size()-1);
			if(arr[X.get(nextX).index][Y.get(nextY).index]==1) {
				arr[X.get(nextX).index][Y.get(nextY).index]=0;
				reject--;
				num=0;
				if(X.get(nextX).value-1!=0) {
					X.add(new Point(X.get(nextX).index, X.get(nextX).value-1));
				}
				X.remove(nextX);
				if(Y.get(nextY).value-1!=0) {
					Y.add(new Point(Y.get(nextY).index, Y.get(nextY).value-1));
				}
				Y.remove(nextY);
			}
			num++;
			if(num==10) {
				break;
			}
		}
		outer:
		for (int i = N/4; i < N*3/4; i++) {
			for (int j = M/4; j < M*3/4; j++) {
				if(i==0&&i==N-1&&j==0&&j==M-1) {
					continue;
				}else if(arr[i][j]==1) {
					arr[i][j]=0;
					reject--;
				}
				if(reject==0) {
					break outer;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
