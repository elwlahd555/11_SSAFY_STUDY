package com.algorithm.programmers;

public class 문자열다루기기본 {
	public static void main(String[] args) {
		String s="a234";
        boolean answer = true;
		char []temp=s.toCharArray();
		if(temp.length==4||temp.length==6) {
			
			for (char c : temp) {
				if(c<'0'||c>'9') {
					answer=false;
					break;
				}
			}
		}else {
			answer=false;
		}
		System.out.println(answer);
	}
}
