package com.ssafy.programmers;

import java.util.LinkedList;

public class _3진법뒤집기 {
	public static void main(String[] args) {
		int n=45;
		int answer=0;
		LinkedList<Integer> que=new LinkedList<Integer>();
		
		while(n!=0) {
			que.add(n%3);
			n=n/3;
		}
		int size=que.size();
		for (int i = 0; i < size; i++) {
			answer+=que.pollFirst()*Math.pow(3, size-i-1);
			
		}
		System.out.println(answer);
	}
}
