package com.algorithm.BJ;

import java.util.Scanner;

public class BJ_1157_단어공부 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String s=sc.next().toUpperCase();
		
		int english[]=new int[26];
		char arr[]=s.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			english[arr[i]-'A']++;
		}
		int result=0;
		char resultnum='A';
		for (int i = 0; i < 26; i++) {
			if(english[i]>result) {
				result=english[i];
				resultnum=(char) (i+'A');
			}
		}
		int cnt=0;
		for (int i = 0; i < 26; i++) {
			if(english[i]==result) {
				cnt++;
			}
		}
		if(cnt>=2) {
			System.out.println("?");
		}else {
			System.out.println(resultnum);
		}
	}
}
