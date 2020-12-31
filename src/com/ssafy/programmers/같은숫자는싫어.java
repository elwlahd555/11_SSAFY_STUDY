package com.ssafy.programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 같은숫자는싫어 {
	public static void main(String[] args) {
		int []arr= {1,1,3,3,0,1,1};
		int[] answer;
		LinkedList<Integer> que=new LinkedList<Integer>();
		
		int temp=-1;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==temp)continue;
			else {
				temp=arr[i];
				que.add(temp);
				
			}
		}
		answer=new int[que.size()];
		int cnt=0;
		for (Integer i : que) {
			answer[cnt++]=i;
		}
		System.out.println(Arrays.toString(answer));
	}
}
