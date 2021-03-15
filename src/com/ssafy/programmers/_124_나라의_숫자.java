package com.ssafy.programmers;

import java.util.LinkedList;

public class _124_나라의_숫자 {
	public static void main(String[] args) {
		int n = 12;
		String answer = "";
		int cnt=1;
		while(n>0) {
			int temp=0;
			temp=(int) (n/Math.pow(3, cnt))/3;
			n-=Math.pow(3, cnt);
			cnt++;
			System.out.println(temp);
		}
	}

}
