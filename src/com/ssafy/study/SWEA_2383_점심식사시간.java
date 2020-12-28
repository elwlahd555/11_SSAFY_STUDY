package com.ssafy.study;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2383_점심식사시간 {
	static int N,people;
	static int arr[][],stair[];

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			people=0;
			N=sc.nextInt();
			arr=new int[N][N];
			stair=new int[2];
			int tempcount=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]=sc.nextInt();
					if(arr[i][j]==1) {
						people++;
					}else if(arr[i][j]>1) {
						stair[tempcount++]=arr[i][j];
					}
				}
			}
			size=new int[people];
			result=Integer.MAX_VALUE;
			dfs(0);
			
			
			
		}
	}
	static int size[];
	static int result;
	private static void dfs(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==people) {
			System.out.println(Arrays.toString(size));
			result=Math.min(result, cal());
			return;
		}
		for (int i = 0; i < 2; i++) {
			size[cnt]=stair[i];
			dfs(cnt+1);
		}
	}
	private static int cal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
