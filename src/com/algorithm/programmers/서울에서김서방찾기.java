package com.algorithm.programmers;

public class 서울에서김서방찾기 {
	public static void main(String[] args) {
		String[] seoul= {"Jane","Kim"};
		String answer="김서방은 ";
		int temp=0;
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				temp=i;
				break;
			}
		}
		answer=answer.concat(temp+"에 있다");
		System.out.println(answer);
	}
}
