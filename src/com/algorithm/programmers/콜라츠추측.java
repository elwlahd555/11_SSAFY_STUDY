package com.algorithm.programmers;

public class 콜라츠추측 {
	public static void main(String[] args) {
		int num=6;
		int answer=0;
		
		while(answer<500){
			if(num==1) {
				break;
			}
			if(num%2==0) {
				num/=2;
			}else if(num%2==1){
				num=(num*3)+1;

			}
            
            answer++;
		}
		if(answer>=500) {
			answer=-1;
		}
		System.out.println(answer);
	}
}
