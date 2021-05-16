package com.test.kakaoIntern;

import java.util.LinkedList;

public class 프로그래밍03 {
	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
		String answer = solution(n, k, cmd);
		System.out.println(answer);
	}

	private static String solution(int n, int k, String[] cmd) {
		int num=n;
		LinkedList<Integer> delete = new LinkedList<Integer>();
		for (int i = 0; i < cmd.length; i++) {
			String temp = cmd[i].split(" ")[0];
			switch (temp) {
			case "D":
				k = k + Integer.parseInt(cmd[i].split(" ")[1]);
				break;
			case "C":
				delete.push(k);
				num--;
				if (k >= num) {
					k--;
				}
				break;
			case "U":
				k = k - Integer.parseInt(cmd[i].split(" ")[1]);
				break;
			case "Z":
				int tempnum = delete.pop();
				if (k >= tempnum) {
					k++;
				}
				num++;
				break;
			}
		}
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < num; i++) {
           answer.append("O");
        }

        while (!delete.isEmpty()) {
           int del = delete.pop();
           answer.insert(del, "X");
        }

		return answer.toString();
	}
}
