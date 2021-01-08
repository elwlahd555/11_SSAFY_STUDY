package com.ssafy.programmers;

public class 이상한문자만들기 {
	public static void main(String[] args) {
		String s="try hello world";
		s=s.toLowerCase();
		String answer="";
		String arr[]=s.split("");
		int index=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(" ")) {
				arr[i]=" ";
				index=0;
			}
			else if(index%2==0) {
				
				arr[i]=arr[i].toUpperCase();
				index++;
			}else {
				index++;
				
			}
			
			answer=answer.concat(arr[i]);
		}
		System.out.println(answer);
	}
}
