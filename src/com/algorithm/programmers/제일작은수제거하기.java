package com.algorithm.programmers;

import java.util.Arrays;

public class 제일작은수제거하기 {
	public static void main(String[] args) {
		int[] arr= {4,3,2,1};
		int temp=Integer.MAX_VALUE;
		int[] answer;
		if(arr.length>1) {
			answer=new int[arr.length-1];
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]<temp) {
					temp=arr[i];
				}
			}
			int index=0;
			for (int i = 0; i < arr.length; i++) {
				if(temp==arr[i])continue;
				else {
					answer[index++]=arr[i];
				}
			}
		}else {
			answer=new int[1];
			answer[0]=-1;
		}
		System.out.println(Arrays.toString(answer));
		
	}
}
