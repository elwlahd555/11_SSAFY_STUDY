package com.algorithm.BJ;

import java.util.Scanner;

public class BJ_2439_별찍기2 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int N=sc.nextInt();
	
	for (int i = 1; i <= N; i++) {
		for (int j = N-i; j > 0; j--) {
			System.out.print(" ");
		}
		for (int j = 0; j < i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
}
