package com.ssafy.programmers;

import java.util.Arrays;


public class H_Index {
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		int N=citations.length;
		int answer=0;
		Arrays.sort(citations);
		
		for (int i = 0; i < N; i++) {
			if(i<=citations[i]&&citations[i]<=N-i) {
				answer=Integer.max(answer, citations[i]);
			}
		}
		System.out.println(answer);
	}
}