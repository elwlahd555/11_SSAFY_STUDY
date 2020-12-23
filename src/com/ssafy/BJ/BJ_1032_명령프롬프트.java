package com.ssafy.BJ;

import java.util.Scanner;

public class BJ_1032_명령프롬프트 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		char arr[][]=new char[N][];
		for (int i = 0; i < N; i++) {
			String s=sc.next();
			arr[i]=s.toCharArray();
		}
		boolean visit[]=new boolean[arr[0].length];
		for (int i = 0; i < arr[0].length; i++) {
			char temp=arr[0][i];
			for (int j = 1; j < N; j++) {
				if(arr[j][i]!=temp)visit[i]=true;
			}
		}
		for (int i = 0; i < visit.length; i++) {
			if(!visit[i]) {
				System.out.print(arr[0][i]);
			}else {
				System.out.print("?");
			}
		}
	}
}
