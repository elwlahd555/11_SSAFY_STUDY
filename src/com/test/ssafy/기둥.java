package com.test.ssafy;

import java.util.Iterator;

/*
건물을 하나 짓기 위해 크기가 모두 동일한 정육면체 모양의 돌들을 이용해서 N개의 기둥을 세웠다.
기둥들을 모두 다른 사람들이 만들어 높이가 다를 수 있다. 하나의 건물을 짓기 위해 기둥들의 높이를 모두 같게 만들려고 한다.
기둥의 높이를 바꾸는 비용은 추가하거나 제거하는 돌의 개수이다.
여분의 돌이 많이 있어서 돌이 모자라는 경우는 없다고 생각하자.
기둥의 높이를 같게 만드는 최소 비용을 계산하라.

N= 5,{1,3,5,6,4}


*
*/
public class 기둥 {
	public static void main(String[] args) {
//		int arr[]= {5,1,16,2,11,6,10,14,18,3,7};
		int arr[]= {17,24,15,16,5,13,9,2,14,4,6,19,22,10};
		int answer=Integer.MAX_VALUE;
		for (int i = 1; i < 100; i++) {
			int temp=0;
			for (int j = 0; j < arr.length; j++) {
				temp+=Math.abs(arr[j]-i);
			}
			answer=Math.min(temp, answer);
			System.out.println("층 : "+i+" 답 : "+ answer);
		}
		System.out.println(answer);
	}
}
