package com.algorithm.BJ;

import java.util.Scanner;

public class BJ_1550_16진수 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String N=sc.next();
		int answer=0;
		char arr[]=N.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i]>='A'&&arr[i]<='Z') {
				answer+=(arr[i]-'A'+10)*Math.pow(16, arr.length-1-i);
			}else {
				answer+=(arr[i]-'0')*Math.pow(16, arr.length-1-i);
			}
		}
		System.out.println(answer);
	}
}
