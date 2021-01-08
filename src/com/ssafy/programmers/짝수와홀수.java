package com.ssafy.programmers;

public class 짝수와홀수 {
	public static void main(String[] args) {
		int num=-9;
		String answer="";
		if(Math.abs(num)%2==1) {
			answer="Odd";
		}else if(Math.abs(num)%2==0){
			answer="Even";
		}
		System.out.println(answer);
	}
}
