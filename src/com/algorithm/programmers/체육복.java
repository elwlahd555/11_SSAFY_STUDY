package com.algorithm.programmers;

import java.util.Arrays;

public class 체육복 {
	public static void main(String[] args) {
		int n=5;
		int[] lost= {2,4};
		int[] reserve= {1,3,5};
		int answer=0;
		int cloth[]=new int[n+1];
		int extra[]=new int[n+1];
		Arrays.fill(cloth, 1);
		cloth[0]=0;
		for (int i = 0; i < lost.length; i++) {
			cloth[lost[i]]--;
		}
		for (int i = 0; i < reserve.length; i++) {
			extra[reserve[i]]++;
		}
		for (int i = 1; i < cloth.length; i++) {
			if(cloth[i]==0&&extra[i]==1) {
				cloth[i]=1;
				extra[i]=0;
			}
		}
		for (int i = 1; i < cloth.length; i++) {
			if(cloth[i]==0) {
				if(extra[i-1]==1) {
					cloth[i]=1;
					extra[i-1]=0;
				}else if(i+1<cloth.length&&extra[i+1]==1) {
					cloth[i]=1;
					extra[i+1]=0;
				}
			}
		}
		for (int i = 0; i < cloth.length; i++) {
			if(cloth[i]==1) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
