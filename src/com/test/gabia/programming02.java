package com.test.gabia;

import java.util.HashSet;

public class programming02 {
	public static void main(String[] args) {
		String s = "abac";
		int answer = 0;
		HashSet<String> result=new HashSet<String>();

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			StringBuilder temp = new StringBuilder();
			temp.append(arr[i]);
			result.add(temp.toString());
			for (int j = i+1; j < arr.length; j++) {
				if(temp.indexOf(String.valueOf(arr[j]))<0) {
					temp.append(arr[j]);
					result.add(temp.toString());
				}else {
					break;
				}
			}
		}
		answer=result.size();
		System.out.println(answer);

	}
}
