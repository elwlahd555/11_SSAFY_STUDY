package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16637_괄호추가하기 {
	static int N,size,result,checknum,check;
	static char arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		arr=bf.readLine().toCharArray();
	}
}
//3 -1
//5 -1
//7 -2
//9 -2
//11 -3
//13 -3
//15 -4
//17 -4
//19 -5
//21 -5