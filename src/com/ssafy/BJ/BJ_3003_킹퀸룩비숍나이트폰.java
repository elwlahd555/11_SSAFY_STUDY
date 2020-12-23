package com.ssafy.BJ;

import java.util.Scanner;

public class BJ_3003_킹퀸룩비숍나이트폰 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int arr[]= {1,1,2,2,2,8};
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]-sc.nextInt()+" ");
		}
	}
}
