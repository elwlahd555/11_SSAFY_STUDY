package com.test.kakaocommerce;

public class programming01 {
	public static void main(String[] args) {
		int[] gift_cards= {5, 4, 5, 4, 5};
		int[] wants= {1, 2, 3, 5, 4};
		int answer = 0;
		int arr[][]=new int[100001][2];
		for (int i = 0; i < gift_cards.length; i++) {
			arr[gift_cards[i]][0]++;
			arr[wants[i]][1]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i][1]>arr[i][0]) {
				answer+=arr[i][1]-arr[i][0];
			}
		}
		System.out.println(answer);
		
	}
}
//		for (int i = 0; i < wants.length; i++) {
//			for (int j = 0; j < wants.length; j++) {
//				if (wants[i] == gift_cards[j]) {
//					gift_cards[j] = 0;
//					answer--;
//					break;
//				}
//			}
//		}
