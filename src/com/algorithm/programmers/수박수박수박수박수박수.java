package com.algorithm.programmers;

public class 수박수박수박수박수박수 {
	public static void main(String[] args) {
		int n=3;
		String answer="";
		String a="수";
		String b="박";
		
		for (int i = 1; i <= n; i++) {
			if(i%2==1) {
				answer = answer.concat(a);
			}else {
				answer=answer.concat(b);
				
			}
		}
		System.out.println(answer);
	}
}