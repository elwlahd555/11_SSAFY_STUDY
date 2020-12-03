package com.ssafy.study;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class SWEA_5658_보물상자비밀번호02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int C = N / 4; // 한변의 길이 : 2-7 --> 회전횟수 결정
			int K = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1); // 정수일때 : o2-o1
				}
			});
			int c = 0;
			while (++c <= C) { // 회전관련 처리 C번
				// 현상태에서 각 변의 길이만큼의 문자열비밀번호 추출하여 set에 넣기

				for (int i = 0; i < N; i += C) {
					String s = "";
					for (int j = 0; j < C; j++) {
						s += arr[i + j];
					}
					set.add(s);
				}

				// 시계방향으로 화나 shift
				char temp = arr[N - 1];
				for (int i = N - 1; i > 0; i--) {
					arr[i] = arr[i - 1];
				}
				arr[0] = temp;
			}
			int k = 0, ans = 0;
			for (String s : set) {
				if (++k == K) {
					ans = Integer.parseInt(s, 16);
					break;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
