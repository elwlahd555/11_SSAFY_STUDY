package com.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
	public static void main(String[] args) {
		int answers[]= {1,2,3,4,5};
        int a[]={1,2,3,4,5};
        int b[]={2,1,2,3,2,4,2,5};
        int c[]={3,3,1,1,2,2,4,4,5,5};
        int answer[];
        int temp[]=new int[4];
        for (int i = 0; i < answers.length; i++) {
			if(a[i%a.length]==answers[i]) {
				temp[1]++;
			}
			if(b[i%b.length]==answers[i]) {
				temp[2]++;
			}
			if(c[i%c.length]==answers[i]) {
				temp[3]++;
			}
		}
        int num=0;
        for (int i = 0; i < temp.length; i++) {
			if(temp[i]>num) {
				num=temp[i];
			}
		}
        ArrayList<Integer> que=new ArrayList<Integer>();
        for (int i = 0; i < temp.length; i++) {
			if(temp[i]==num) {
				que.add(i);
			}
		}
        answer=new int[que.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i]=que.get(i);
		}
        Arrays.sort(answer);
        
        System.out.println(Arrays.toString(answer));
	}
}
