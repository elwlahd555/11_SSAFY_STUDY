package com.ssafy.study;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_5658_보물상자비밀번호 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T =sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			char[] arr=sc.next().toCharArray();
			int memo[][]=new int[N/4][4];
			LinkedList<Character> que=new LinkedList<>();
			for (int i = 0; i < arr.length; i++) {
				que.add(arr[i]);
			}
			int count=0;
			String temp="";
			for (int i = 0; i < N/4; i++) {
				temp="";
				for (int j = count; j < count+N/4; j++) {
					temp+=que.get(j);
				}
				count+=N/4;
//				memo[0][i]=Integer.parseInt(temp);
				
				System.out.println(temp);
				
			}
			
		}
	}
}
