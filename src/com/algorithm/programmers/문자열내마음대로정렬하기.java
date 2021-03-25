package com.algorithm.programmers;

import java.util.Arrays;

public class 문자열내마음대로정렬하기 {
	public static void main(String[] args) {
		String[] strings = { "sun", "bed", "car" };
		int n = 1;
		Object[] temp = Arrays.stream(strings).sorted((s1, s2) -> {
			if (s1.charAt(n) == s2.charAt(n)) {
				return s1.compareTo(s2);
			} else {
				return s1.charAt(n) - s2.charAt(n);
			}
		}).toArray();
		String[] answer = new String[temp.length];
		for (int i = 0; i < temp.length; i++) {
			answer[i] = (String) temp[i];
		}
		System.out.println(Arrays.toString(answer));
	}

}
