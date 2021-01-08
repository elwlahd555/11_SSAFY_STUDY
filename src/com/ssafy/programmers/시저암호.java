package com.ssafy.programmers;

public class 시저암호 {
	public static void main(String[] args) {
		String s = "AB";
		int n = 1;

		String answer = "";

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				if(arr[i]+n>'Z') {
					arr[i] = (char) ((arr[i] + n) % 'Z'+'A'-1);
					
				}else {
					arr[i] = (char) (arr[i] + n);
					
				}
			} else if (arr[i] == ' ') {
				arr[i] = ' ';
			} else if (arr[i] >= 'a' && arr[i] <= 'z') {
				if(arr[i]+n>'z') {
					arr[i] = (char) ((arr[i] + n) % 'z'+'a'-1);
					
				}else {
					arr[i] = (char) (arr[i] + n);
					
				}

			}
		}
		answer = String.copyValueOf(arr);
		System.out.println(answer);
	}
}
