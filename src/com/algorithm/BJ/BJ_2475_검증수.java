package com.algorithm.BJ;

import java.util.Scanner;

public class BJ_2475_검증수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int answer=0;
		for (int i = 0; i < 5; i++) {
			answer+=(int) Math.pow(sc.nextInt(),2);
		}
		System.out.println(answer%10);
	}
}
