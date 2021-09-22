package com.study.array;

import java.util.Arrays;

public class random_array02 {
	public static void main(String[] args) {
		int N=13;
		int M=30;
		int reject=50;
		int arr[][]=new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], 1);
			
		}
		int cnt=0;
		while(reject!=cnt) {
			
			int x=(int)(Math.random()*(N-2))+1;
			if(arr[x][cnt%(M-2)+1]==1) {
				arr[x][cnt%(M-2)+1]=0;
				cnt++;
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
