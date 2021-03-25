package com.algorithm.SWEA;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_5658_보물상자비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			LinkedList<Character> que = new LinkedList<>();
			for (int i = 0; i < arr.length; i++) {
				que.add(arr[i]);
			}
			PriorityQueue<Integer> resultque = new PriorityQueue<Integer>();
			for (int k = 0; k < N / 4; k++) {
				for (int i = 0; i < 4; i++) {
					int temp = 0;
					for (int j = i * N / 4; j < (i + 1) * N / 4; j++) {
						if (que.get(j) >= 'A') {
							temp += (que.get(j) - 'A' + 10) * Math.pow(16, (N / 4 - j % (N / 4)) - 1);

						} else {
							temp += (que.get(j) - '0') * Math.pow(16, (N / 4 - j % (N / 4)) - 1);

						}
					}
					if (!resultque.contains(temp)) {

						resultque.add(temp);
					}
				}

				que.addFirst(que.pollLast());

			}
			int size = resultque.size();
			int result[] = new int[size];
			for (int i = size - 1; i >= 0; i--) {
				result[i] = resultque.poll();
			}
			System.out.println("#" + t + " " + result[K - 1]);
		}
	}
}
