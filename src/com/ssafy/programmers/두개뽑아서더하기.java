package com.ssafy.programmers;

import java.util.TreeSet;

public class 두개뽑아서더하기 {
	public static void main(String[] args) {
		int[] numbers = {2,1,3,4,1};
		int answer[];
		TreeSet<Integer> tset=new TreeSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				
				tset.add(numbers[i]+numbers[j]);
			}
		}
		answer=new int[tset.size()];
		int cnt=0;
		for (Integer i : tset) {
			answer[cnt]=i;
			cnt++;
		}
	}
	
}
