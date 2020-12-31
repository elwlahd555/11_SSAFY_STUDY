package com.ssafy.programmers;

public class 가운데글자가져오기 {
	public static void main(String[] args) {
		String s="abcde";
		String answer="";
		
		int size=s.length();
		int temp=size/2;
		String splits[]=s.split("");
		if(size%2==1) {
			answer=splits[temp];
		}else {
			answer=answer.concat(splits[temp-1]).concat(splits[temp]);
			
			
			
		}
		System.out.println(answer);
	}
}
