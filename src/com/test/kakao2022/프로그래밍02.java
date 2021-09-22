package com.test.kakao2022;

import java.math.BigInteger;

public class 프로그래밍02 {
	public static void main(String[] args) {
		int n = 110011;
		int k = 10;
		System.out.println(solution(n, k));
	}

	private static int solution(int n, int k) {
		String number = new BigInteger(String.valueOf(n)).toString(k);
		char arr[] = number.toCharArray();
		StringBuffer sb = new StringBuffer();
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '0') {
				if(sb.toString().equals("")) {
					continue;
				}
				BigInteger check = new BigInteger(sb.toString());
				if (check.isProbablePrime(10)) {
					answer++;
				}
				sb=new StringBuffer();
			} else {
				sb.append(arr[i]);
			}
		}
		if (!sb.toString().equals("")) {
			BigInteger check = new BigInteger(sb.toString());
			if (check.isProbablePrime(10)) {
				answer++;
			}
		}
		return answer;
	}
}
