package com.algorithm.programmers;

public class 문자열_압축 {
	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede";
		int answer = 0;
		int size = s.length() / 2;
		if (size == 0) {
			size = 1;
		}
		int cnt = 1;
		int stringsize = 1;
		String result = "";
		int resultnum = Integer.MAX_VALUE;
		while (cnt <= size) {
			String subresult = "";
			int subresultnum = 0;
			String temp = s.substring(0, cnt);
			int i = cnt;
			while (true) {
				if (i + cnt <= s.length()) {
					String check = s.substring(i, i + cnt);
					if (temp.equals(check)) {
						stringsize++;
						if (i + cnt == s.length() && stringsize == 1) {
							subresult = subresult + temp;
							stringsize = 1;
							break;
						} else if (i + cnt == s.length()) {
							subresult = subresult + stringsize + temp;
							temp = check;
							stringsize = 1;
							break;
						}
					} else {
						if (stringsize == 1) {
							subresult = subresult + temp;
							temp = check;
							stringsize = 1;
						} else {
							subresult = subresult + stringsize + temp;
							temp = check;
							stringsize = 1;
						}
					}
				} else if (stringsize == 1) {
					subresult = subresult + temp + s.substring(i);
					stringsize = 1;
				} else {
					subresult = subresult + stringsize + temp + s.substring(i);
					stringsize = 1;
				}
				if (i + cnt > s.length()) {
					break;
				}
				i += cnt;
			}
			subresultnum = subresult.length();
			if (subresultnum < resultnum) {
				resultnum = subresultnum;
				result = subresult;
			}
			cnt++;
		}
		System.out.println(result);
		System.out.println(resultnum);

	}
}
