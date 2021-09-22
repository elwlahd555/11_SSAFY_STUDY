package com.study.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class random_array03 {
	public static void main(String[] args) {
		int N=13;
		int M=30;
		int reject=150;
		int PerReject=reject/(M-2);
		int extra=reject%(M-2);
		int arr[][]=new int[N][M];
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], 1);
			
		}
		while(PerReject!=0) {
			for (int i = 1; i < M-1; i++) {
				int x=(int)(Math.random()*(N-2))+1;
				if(arr[x][i]==1) {
					arr[x][i]=0;
				}else {
					i--;
				}
			}
			PerReject--;
		}
		Set<Integer> extraY=new HashSet<Integer>();
		while(extraY.size()!=extra) {
			extraY.add((int)(Math.random()*(M-2))+1);
		}
		for (Integer i : extraY) {
			while(true) {
				int extraX=(int)(Math.random()*(N-2))+1;
				if(arr[extraX][i]==1) {
					arr[extraX][i]=0;
					break;
				}
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
