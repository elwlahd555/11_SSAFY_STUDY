package com.ssafy.study;

import java.util.Scanner;

public class SWEA_4008_숫자만들기 {
	private static int  N;
	private static int number[];
	private static boolean visit[];
	private static int check[];
	private static int temp[];
	private static int min;
	private static int max;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			number = new int[N];
			temp=new int[N-1];
			check=new int[N-1];
			visit=new boolean[N-1];
			min=Integer.MAX_VALUE;
			max=0;
			int start=0;
			for (int i = 0; i < 4; i++) {
				int type=sc.nextInt();
				for (int j = start; j < start+type; j++) {
					check[j]=i;
				}
				start+=type;
			}
			for (int i = 0; i < N; i++) {
				number[i]=sc.nextInt();
			}
			dfs(0);

			System.out.println("#"+t+" "+ (max-min));
		}
	}
	private static void dfs(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==N-1) {
			cal();
			return;
		}
		for (int i = 0; i < N-1; i++) {
			if(visit[i])continue;
			temp[cnt]=check[i];
			visit[i]=true;
			dfs(cnt+1);
			visit[i]=false;
		}
	}
	private static void cal() {
		// TODO Auto-generated method stub
		int sum=number[0];
		for (int i = 0; i < N-1; i++) {
			switch(temp[i]) {
			case 0:
				sum+=number[i+1];
				break;
			case 1:
				sum-=number[i+1];
				break;
			case 2:
				sum*=number[i+1];
				break;
			case 3:
				sum/=number[i+1];
				break;
			}
		}
		min=Math.min(min, sum);
		max=Math.max(max, sum);
	}
}
