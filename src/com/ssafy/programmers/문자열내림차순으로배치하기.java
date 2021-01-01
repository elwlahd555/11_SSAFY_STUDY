package com.ssafy.programmers;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		String answer = "";
		Character[] temp = new Character[s.length()];
		for (int i = 0; i < s.length(); i++) {
			temp[i] = s.charAt(i);
		}
		Arrays.sort(temp, Collections.reverseOrder());
		for (Character c : temp) {
			answer += c;
		}
		System.out.println(answer);
	}
}
