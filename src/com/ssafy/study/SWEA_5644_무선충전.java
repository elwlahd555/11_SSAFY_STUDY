package com.ssafy.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_5644_무선충전 {
	private static int dx[] = { 0, -1, 0, 1, 0 };
	private static int dy[] = { 0, 0, 1, 0, -1 };

	public static class Point {
		int x, y;
		int C;
		int P;

		public Point(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int A;
	private static List<Point> BCque;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 10;
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int M = sc.nextInt();
			A = sc.nextInt();
			int result[][] = new int[3][M + 1];
			int BC[][] = new int[A + 1][5];
			LinkedList<Point> queA = new LinkedList<>();
			LinkedList<Point> queB = new LinkedList<>();
			queA.add(new Point(1, 1));
			queB.add(new Point(10, 10));
			for (int i = 0; i < M; i++) {
				int temp = sc.nextInt();
				queA.add(new Point(queA.get(i).x + dx[temp], queA.get(i).y + dy[temp]));
			}
			for (int i = 0; i < M; i++) {
				int temp = sc.nextInt();
				queB.add(new Point(queB.get(i).x + dx[temp], queB.get(i).y + dy[temp]));
			}
//			for (int i = 0; i <= M; i++) {
//				System.out.println(queA.poll().x);
//			}
			BCque = new ArrayList<>();
			for (int i = 1; i <= A; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int C = sc.nextInt();
				int P = sc.nextInt();
				BCque.add(new Point(x, y, C, P));
			}
			ArrayList<Integer> Asum =new ArrayList<Integer>();
			ArrayList<Integer> Bsum =new ArrayList<Integer>();
			while (!queA.isEmpty()) {
				int size = M + 1 - queA.size();
				Point perA = queA.poll();
				Point perB = queB.poll();
				
				Asum=getAp(perA.x,perA.y);
				Bsum=getAp(perB.x,perB.y);
				if(Asum.size()==0 && Bsum.size()==0) result[0][size]=0;
				else if(Asum.size()==0) result[0][size]+=getMaxPower(Bsum);
				else if(Bsum.size()==0) result[0][size]+=getMaxPower(Asum);
				int temp=0;
				int max=0;
				for(Integer a : Asum) {
					for (Integer b : Bsum) {
						if(a!=b)temp=BCque.get(a).P+BCque.get(b).P;
						else temp = Math.max(BCque.get(a).P, BCque.get(b).P);
						
						if(max<temp) max= temp;
					}
				}
				result[0][size]+=max;

			}
			int sum = 0;
				for (int j = 0; j <= M; j++) {
					sum += result[0][j];
				}
				
			System.out.println("#" + t + " " + sum);

		}
	}

	private static int getMaxPower(ArrayList<Integer> apList) {
		// TODO Auto-generated method stub
		int max=0;
		for(Integer a:apList) {
			if(max<BCque.get(a).P) max=BCque.get(a).P;
		}
		return max;
		
	}

	private static ArrayList<Integer> getAp(int x, int y) {
		ArrayList<Integer> apList=new ArrayList<Integer>();
		int d=0;
		for (int i = 0; i < A; i++) {
			d= Math.abs(BCque.get(i).x-x)+Math.abs(BCque.get(i).y-y);
			if(d<=BCque.get(i).C) apList.add(i);
		}
		// TODO Auto-generated method stub
		return apList;
	}
}
