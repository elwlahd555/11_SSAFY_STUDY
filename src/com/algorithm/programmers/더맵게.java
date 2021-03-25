package com.algorithm.programmers;

import java.util.PriorityQueue;

public class 더맵게 {
	public static void main(String[] args) {
		int []scoville= {1,2,3,9,10,12};
		int K=7;

		int answer=0;
		PriorityQueue<Integer>que=new PriorityQueue<Integer>();
		for (int i = 0; i < scoville.length; i++) {
			que.add(scoville[i]);
		}
		int temp=que.poll();
		while(temp<K) {
			if(que.size()==0) {
				answer=-1;
				break;
			}
			int number=temp+(que.poll()*2);
			que.add(number);
			temp=que.poll();
			answer++;
		}
		System.out.println(answer);
	}
}
