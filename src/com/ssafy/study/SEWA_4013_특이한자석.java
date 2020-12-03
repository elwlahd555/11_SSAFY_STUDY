package com.ssafy.study;

import java.util.LinkedList;
import java.util.Scanner;

public class SEWA_4013_특이한자석 {
	private static LinkedList<Integer> first;
	private static LinkedList<Integer> second;
	private static LinkedList<Integer> third;
	private static LinkedList<Integer> forth;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int s = 8;
		for (int t = 1; t <= T; t++) {
			int K = sc.nextInt();
			first = new LinkedList<Integer>();
			second = new LinkedList<Integer>();
			third = new LinkedList<Integer>();
			forth = new LinkedList<Integer>();
			for (int i = 0; i < s; i++) {
				first.add(sc.nextInt());
			}
			for (int i = 0; i < s; i++) {
				second.add(sc.nextInt());
			}
			for (int i = 0; i < s; i++) {
				third.add(sc.nextInt());
			}
			for (int i = 0; i < s; i++) {
				forth.add(sc.nextInt());
			}
			for (int k = 0; k < K; k++) {
				int arr[] = new int[5];

				int number = sc.nextInt();
				int type = sc.nextInt();
				switch (number) {
				case 1:
					arr[1] = type;
					type *= -1;
					if (first.get(2) != second.get(6)) {
						arr[2] = type;
						type *= -1;
						if (second.get(2) != third.get(6)) {
							arr[3] = type;
							type *= -1;
							if (third.get(2) != forth.get(6)) {
								arr[4] = type;
							}
						}
					}
					break;
				case 2:
					arr[2] = type;
					type *= -1;
					if (second.get(6) != first.get(2)) {
						arr[1] = type;
					}
					if (second.get(2) != third.get(6)) {
						arr[3] = type;
						type *= -1;
						if (third.get(2) != forth.get(6)) {
							arr[4] = type;
							type *= -1;
						}
					}
					break;
				case 3:
					arr[3] = type;
					type *= -1;
					if (third.get(2) != forth.get(6)) {
						arr[4] = type;
					}
					if (third.get(6) != second.get(2)) {
						arr[2] = type;
						type *= -1;
						if (second.get(6) != first.get(2)) {
							arr[1] = type;
							type *= -1;
						}
					}
					break;
				case 4:
					arr[4] = type;
					type *= -1;
					if (forth.get(6) != third.get(2)) {
						arr[3] = type;
						type *= -1;
						if (third.get(6) != second.get(2)) {
							arr[2] = type;
							type *= -1;
							if (second.get(6) != first.get(2)) {
								arr[1] = type;
							}
						}
					}
					break;
				}
				for (int i = 1; i <= 4; i++) {
					if (arr[i] != 0) {
						spin(i, arr[i]);
					}
				}
			}
			int result = 0;
			result += first.get(0) * 1;
			result += second.get(0) * 2;
			result += third.get(0) * 4;
			result += forth.get(0) * 8;
			System.out.println("#" + t + " " + result);
		}
	}

	private static void spin(int i, int j) {
		switch (i) {
		case 1:
			if (j == -1) {
				first.add(first.poll());
			} else {
				first.addFirst(first.pollLast());
			}
			break;
		case 2:
			if (j == -1) {
				second.add(second.poll());
			} else {
				second.addFirst(second.pollLast());
			}
			break;
		case 3:
			if (j == -1) {
				third.add(third.poll());
			} else {
				third.addFirst(third.pollLast());
			}
			break;
		case 4:
			if (j == -1) {
				forth.add(forth.poll());
			} else {
				forth.addFirst(forth.pollLast());
			}
			break;
		}

	}
}
