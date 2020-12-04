package com.ssafy.study;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4008_숫자만들기 {
	private static int N;
	private static int number[];	//숫자 배열
	private static int check[];	//연산자 갯수
	private static int temp[];	//연산자 순열
	private static int min;
	private static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		check = new int[4];
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			number = new int[N];
			temp = new int[N - 1];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < 4; i++) {
				check[i] = sc.nextInt();
				}
			for (int i = 0; i < N; i++) {
				number[i] = sc.nextInt();
			}
			dfs(0);

			System.out.println("#" + t + " " + (max - min));
		}
	}

	private static void dfs(int cnt) { // 연산자의 순열 생성
		// TODO Auto-generated method stub
		if (cnt == N - 1) {
			cal();
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (check[i]==0)
				continue;
			temp[cnt] = i;
			check[i]--;
			dfs(cnt + 1);
			check[i]++;
		}
	}

	private static void cal() {
		// TODO Auto-generated method stub
		int sum = number[0];
		for (int i = 0; i < N - 1; i++) {
			int currNumber = number[i + 1];
			switch (temp[i]) {
			case 0:
				sum += currNumber;
				break;
			case 1:
				sum -= currNumber;
				break;
			case 2:
				sum *= currNumber;
				break;
			case 3:
				sum /= currNumber;
				break;
			}
		}
		min = Math.min(min, sum);
		max = Math.max(max, sum);
	}
}
