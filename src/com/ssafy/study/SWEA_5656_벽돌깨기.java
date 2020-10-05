package com.ssafy.study;

import java.util.Scanner;

public class SWEA_5656_벽돌깨기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=sc.nextInt();
			int W=sc.nextInt();
			int H=sc.nextInt();
			int arr[][]=new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			
		}
	}
}
