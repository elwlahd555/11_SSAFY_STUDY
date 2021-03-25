package com.algorithm.SWEA;

import java.util.Arrays;
import java.util.LinkedList;

public class test {
	public static void main(String[] args) {
		LinkedList<Integer> que=new LinkedList<Integer>();
		que.add(1);
		que.add(2);
		que.add(3);
		que.add(4);
		que.pollLast();
		for (int i = 0; i < que.size(); i++) {
			System.out.println(que.get(i));
		}
	}
}
