package com.algorithm.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class 튜플 {
	public static void main(String[] args) {
		ArrayList<Integer> answer = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i));
		}
	}

	private static ArrayList<Integer> solution(String s) {

		// 1. 튜플을 만들 ArrayList 객체.
		ArrayList<Integer> answer = new ArrayList<>();
		// 2. 가장 앞과 뒤 {{ 를 제거한다. }{,를 -로 대체후 -기준으로 split
		String str[] = s.substring(2, s.length() - 2).replace("},{", "-").split("-");
		// 3. 나눠진 문자열 배열을 길이에 따라 다시 정렬한다.
		Arrays.sort(str, new Comparator<String>() {
			public int compare(String o1, String o2) {

				return Integer.compare(o1.length(), o2.length());
			}
		});
		for (String x : str) {
			String[] temp = x.split(",");
			for (int i = 0; i < temp.length; i++) {
				int n = Integer.parseInt(temp[i]);
				if (!answer.contains(n))
					answer.add(n);
			}
		}
		return answer;
	}
}
