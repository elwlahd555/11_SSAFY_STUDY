package com.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		int[] arr= {5,9,7,10};
		int divisor=5;
//		int[] answer;
//		ArrayList<Integer> arrlist=new ArrayList<Integer>();
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i]%divisor==0) {
//				arrlist.add(arr[i]);
//			}
//		}
//		if(arrlist.size()==0) {
//			answer= new int[1];
//			answer[0]=-1;
//		}else {
//			answer=new int[arrlist.size()];
//			for (int i = 0; i < arrlist.size(); i++) {
//				answer[i]=arrlist.get(i);
//			}
//			
//		}
		int []answer=Arrays.stream(arr).filter(i -> i%divisor==0).toArray();
		if(answer.length==0) {
			answer=new int[] {-1};
		}
		Arrays.sort(answer);
		System.out.println(Arrays.toString(answer));
	}
}
