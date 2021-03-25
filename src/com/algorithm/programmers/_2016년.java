package com.algorithm.programmers;

public class _2016년 {
	public static void main(String[] args) {
		int a=5;
		int b=24;
		String day[]= {"SUN", "MON", "TUE", "WED","THU","FRI","SAT"};
		
		int temp=4;
		String answer="";
		
		if(a==1) {
			temp+=0;
		}else if(a==2) {
			temp+=31;
		}else if(a==3) {
			temp+=60;
		}else if(a==4) {
			temp+=91;
		}else if(a==5) {
			temp+=121;
		}else if(a==6) {
			temp+=152;
		}else if(a==7) {
			temp+=182;
		}else if(a==8) {
			temp+=213;
		}else if(a==9) {
			temp+=244;
		}else if(a==10) {
			temp+=274;
		}else if(a==11) {
			temp+=305;
		}else if(a==12) {
			temp+=335;
		}
		temp+=b;
		answer=day[temp%7];
		System.out.println(answer);
	}
}
