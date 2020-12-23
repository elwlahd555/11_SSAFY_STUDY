package com.ssafy.BJ;

import java.util.Scanner;

public class BJ_1212_8진수2진수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String bin[]= {"000","001","010","011","100","101","110","111"};
		String bin1[]= {"0","1","10","11","100","101","110","111"};
		String s=sc.next();
		char arr[]=s.toCharArray();
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if(i==0) {
				sb.append(bin1[arr[i]-'0']);
				
			}else {
				
				sb.append(bin[arr[i]-'0']);
			}
		}
		System.out.println(sb);
	}
}
//public class Main {
//	static Scanner sc = new Scanner(System.in);
//	public static void main(String[] args) {
//		String s = sc.nextLine();
//		
//		System.out.println(new BigInteger(s, 8).toString(2));
//
//
//	}
//}