package com.study.array;

import java.util.Arrays;

public class random_array01 {
	public static void main(String[] args) {
		int N=13;
		int M=30;
		int reject=50;
		int arr[][]=new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], 1);
			
		}
		while(reject!=0) {
			int x=(int)(Math.random()*(N-2))+1;
			int y=(int)(Math.random()*(M-2))+1;
			if(arr[x][y]==1) {
				reject--;
				arr[x][y]=0;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
