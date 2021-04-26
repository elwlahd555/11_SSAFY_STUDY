package com.algorithm.programmers;

public class 다음_큰_숫자02 {
	public static void main(String[] args) {
		int answer=solution(78);
		System.out.println(answer);
		
	}

	private static int solution(int n) {
		int answer = 0;
		String num = Integer.toBinaryString(n);
		int nc = 0;
		char[] charn = num.toCharArray();
		for (int i = 0; i < charn.length; i++) {
			if (charn[i] == '1') {
				nc++;
			}
		}
		for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
			char[] temp = Integer.toBinaryString(i).toCharArray();
			int tempnum = 0;
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] == '1') {
					tempnum++;
				}
			}
			if (nc == tempnum) {
				answer = i;
				break;
			}

		}
		return answer;
	}
}
