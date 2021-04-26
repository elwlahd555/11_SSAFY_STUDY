package com.algorithm.programmers;

public class 올바른_괄호 {
	public static void main(String[] args) {
		System.out.println(solution("()()"));

	}

	private static boolean solution(String s) {
		boolean answer = true;
		int a = 0;
		int b = 0;

		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] == '(') {
				a++;
			} else {
				b++;
			}
			if (b > a) {
				answer = false;
				break;
			}
		}
		if (b != a) {
			answer = false;
		}
		return answer;
	}
}
