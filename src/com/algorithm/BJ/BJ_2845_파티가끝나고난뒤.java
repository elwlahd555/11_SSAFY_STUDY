package com.algorithm.BJ;

import java.util.Scanner;

public class BJ_2845_파티가끝나고난뒤 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int L=sc.nextInt();
		int P=sc.nextInt();
		for (int i = 0; i < 5; i++) {
			System.out.print(sc.nextInt()-L*P+" ");
		}
	}
}
