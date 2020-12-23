package com.ssafy.BJ;

import java.util.Scanner;

public class BJ_1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int cnt=0;
		int temp=N;
		int temp2=0;
		while(true) {
			temp2=(temp/10)+(temp%10);
			temp=(temp%10)*10+(temp2%10);
			cnt++;
			if(temp==N) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
