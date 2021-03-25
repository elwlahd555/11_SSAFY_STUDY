package com.test.line;

import java.util.Arrays;
import java.util.LinkedList;

public class 프로그래밍2 {
	public static void main(String[] args) {
		String inp_str="aaaaZZZZ)";
		int[] answer = {};
		LinkedList<Integer> answerlist=new LinkedList<Integer>();
		if(inp_str.length()>15||inp_str.length()<8) {
			answerlist.add(1);
		}
		char temp[]=inp_str.toCharArray();
		boolean check[]=new boolean[5];
		boolean check2=true;
		for (int i = 0; i < temp.length; i++) {
			int num=0;
			if(temp[i]>='A'&&temp[i]<='Z') {
				check[1]=true;
				num++;
			}else if(temp[i]>='a'&&temp[i]<='z') {
				check[2]=true;
				num++;
			}else if(temp[i]>='0'&&temp[i]<='9') {
				check[3]=true;
				num++;
			}else if("~!@#$%^&*".contains(String.valueOf(temp[i]))) {
				check[4]=true;
				num++;
			}
			if(num==0) {
				check2=false;
			}
		}
		if(!check2) {
			answerlist.add(2);
		}
		int cnt=0;
		for (int i = 0; i < check.length; i++) {
			if(check[i]) {
				cnt++;
			}
		}
		if(cnt<3) {
			answerlist.add(3);
		}
		cnt=0;
		char tempchar=temp[0];
		for (int i = 0; i < temp.length; i++) {
			if(temp[i]==tempchar) {
				cnt++;
				tempchar=temp[i];
			}else {
				cnt=1;
				tempchar=temp[i];
			}
			if(cnt>=4) {
				answerlist.add(4);
				break;
			}
		}
		for (int i = 0; i < temp.length; i++) {
			char tempchar1=temp[i];
			cnt=0;
			for (int j = 0; j < temp.length; j++) {
				if(tempchar1==temp[j]) {
					cnt++;
				}
			}
			if(cnt>=5) {
				answerlist.add(5);
				break;
			}
		}
		if(answerlist.size()==0) {
			answer= new int[1];
			answer[0]=0;
		}else {
			answer=new int[answerlist.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i]=answerlist.poll();
			}
			
		}
		System.out.println(Arrays.toString(answer));

	}
}
