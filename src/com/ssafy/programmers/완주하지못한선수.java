package com.ssafy.programmers;

import java.util.Arrays;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		String answer = "";
		Arrays.sort(completion);
		Arrays.sort(participant);
		int i;
		for (i = 0; i < completion.length; i++) {
			if(!completion[i].equals(participant[i])) {
				break;
			}
		}
		answer=participant[i];
		System.out.println(answer);
		
	}
}
