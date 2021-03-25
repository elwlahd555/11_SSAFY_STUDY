package com.algorithm.programmers;

public class 다리를_지나는_트럭 {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int answer = 0;
		int arr[] = new int[bridge_length];
		int temp = 0;
		int k = 0;
		while (true) {
			int num = 0;
			int num2 = 0;
			for (int i = 0; i < arr.length; i++) {
				num = arr[i];
				arr[i] = num2;
				num2 = num;
			}
			temp -= num2;
			if (k < truck_weights.length && temp + truck_weights[k] <= weight) {
				temp += truck_weights[k];
				arr[0] = truck_weights[k];
				k++;
			}
			answer++;
			if (check(arr)) {
				break;
			}
		}
		System.out.println(answer);
	}

	private static boolean check(int[] arr) {
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			n += arr[i];
		}
		if (n == 0) {
			return true;
		}
		return false;
	}
}
