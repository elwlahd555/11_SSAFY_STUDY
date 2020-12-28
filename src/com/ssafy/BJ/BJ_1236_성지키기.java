package com.ssafy.BJ;

import java.util.Scanner;

public class BJ_1236_성지키기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		char arr[][]=new char[N][M];
		int cntN=0;
		int cntM=0;
		
		for (int i = 0; i < N; i++) {
			String s=sc.next();
			arr[i]=s.toCharArray();
		}
		for (int i = 0; i < N; i++) {
			boolean check = false;
			for (int j = 0; j < M; j++) {
				if(arr[i][j]!='.') {
					check=true;
				}
			}
			if(!check)cntN++;
		}
		for (int i = 0; i < M; i++) {
			boolean check = false;
			for (int j = 0; j < N; j++) {
				if(arr[j][i]!='.') {
					check=true;
				}
			}
			if(!check)cntM++;
		}
		System.out.println(Math.max(cntN, cntM));
	}
}
