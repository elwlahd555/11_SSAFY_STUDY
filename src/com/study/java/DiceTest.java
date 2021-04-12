package com.study.java;

import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	
	
	private static int N, numbers[],totalCnt;
	private static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		numbers=new int[N];
		isSelected=new boolean[7];
		
		int mode =sc.nextInt();
		totalCnt=0;
		
		switch(mode) {
		
		case 1: //주사위 던지기 1 : 중복순열
			dice1(0);
			break;
		case 2: //주사위 던지기 2 : 순열
			dice2(0);
			break;
		case 3://주사위 던지기 3 : 중복조합
			dice3(0,1);
			break;
		case 4://주사위 던지기 4 : 조합
			dice4(0,1);
			break;
			
		}
		System.out.println("총 경우의 수 : " + totalCnt);
		
	}
	//cnt 주사위 던지기
	private static void dice1(int cnt) {//중복순열 cnt : 현재까지 던진 주사위 수
		
		if(cnt==N) {
			++totalCnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1;i<=6;i++) {
			numbers[cnt]=i;
			dice1(cnt+1);
		}
		
		
		
	}
	private static void dice2(int cnt) {//순열 cnt : 현재까지 던진 주사위 수
		
		if(cnt==N) {
			++totalCnt;
			System.out.println(Arrays.toString(numbers));
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
	private static void dice3(int cnt,int start) {//중복조합
		
		if(cnt==N) {
			++totalCnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for(int i=start;i<=6;i++) {
			numbers[cnt]=i;
			dice3(cnt+1,i);
		}
		
		
	}
	private static void dice4(int cnt,int start) {//조합
		
		if(cnt==N) {
			++totalCnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for(int i=start;i<=6;i++) {
			numbers[cnt]=i;
			dice4(cnt+1,i+1);
		}
		
		
	}

}