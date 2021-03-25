package com.test.line;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 프로그래밍4 {
	
	public static void main(String[] args) {
		String[] data = { "1 ROOTA 0", "2 AA 1", "3 ZZZ 1", "4 AABAA 1", "5 AAAAA 1", "6 AAAA 1", "7 BAAAAAAA 1", "8 BBAA 1", "9 CAA 1", "10 ROOTB 0", "11 AA 10" };
		String word = "AA";
		String[] answer = {};
		String dataset[][]=new String[data.length][3];
		for (int i = 0; i < dataset.length; i++) {
			
			StringTokenizer st=new StringTokenizer(data[i]," ");
			for (int j = 0; j < 3; j++) {
				dataset[i][j]=st.nextToken();
			}
		}
//		LinkedList<String> list=new LinkedList<String>();
		PriorityQueue<String> list=new PriorityQueue<String>();
		for (int i = 0; i < dataset.length; i++) {
			if(dataset[i][1].contains(word)) {
				list.add(dataset[i][1]);
			}
		}
		for (String string : list) {
			System.out.println(string);
		}
	}

}
