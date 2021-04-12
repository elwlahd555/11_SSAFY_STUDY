package com.study.java;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest2 {
	
	private static int N,numbers[],TotalCnt;
	private static boolean isSelected[];
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		numbers=new int[N];
		isSelected=new boolean[7];
		int menu=sc.nextInt();
		
		switch(menu) {
		case 1:
			dice1(0);
			break;
		case 2:
			dice2(0);
			break;
		case 3:
			dice3(0,1);
			break;
		case 4:
			dice4(0,1);
			break;
			
		}
		System.out.println(TotalCnt);
		System.out.println(Arrays.toString(numbers));
		
	}






	private static void dice1(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==N) {
			++TotalCnt;
			return;
		}
		for(int i=1;i<=6;i++) {
			numbers[cnt]=i;
			dice1(cnt+1);
		}
		
	}
	private static void dice2(int cnt) {
		// TODO Auto-generated method stub
		if(cnt==N) {
			++TotalCnt;
			return;
		}
		for(int i=1;i<=6;i++) {
			if(isSelected[i])continue;
			numbers[cnt]=i;
			isSelected[i]=true;
			dice2(cnt+1);
			isSelected[i]=false;
		}
		
	}
	private static void dice3(int cnt,int start) {
		// TODO Auto-generated method stub
		if(cnt==N) {
			++TotalCnt;
			return;
			
		}
		for(int i=start;i<=6;i++) {
			numbers[cnt]=i;
			dice3(cnt+1,i);
		}
		
	}

	private static void dice4(int cnt,int start) {
		// TODO Auto-generated method stub
		if(cnt==N) {
			++TotalCnt;
			return;
		}
		for(int i=start;i<=6;i++) {
			numbers[cnt]=i;
			dice4(cnt+1,start+1);
		}
	}
}