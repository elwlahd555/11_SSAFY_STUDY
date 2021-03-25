package com.algorithm.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class 직사각형별찍기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		char arr[][]=new char[b][a];
		
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], '*');
			
		}
		for (int i = 0; i < arr.length; i++) {
			
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
				
			}
			System.out.println();
		}
	}
}
