package com.test.line;

import java.util.StringTokenizer;

public class 프로그래밍1 {
	public static void main(String[] args) {
		String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
				"GAME C++ C# JAVASCRIPT C JAVA" };
		String[] languages = { "JAVA", "JAVASCRIPT" };
		int[] preference = { 7, 5 };

		String answer = "";
		String[][] temptable = new String[table.length][6];
		for (int i = 0; i < table.length; i++) {
			StringTokenizer st = new StringTokenizer(table[i], " ");
			temptable[i][0] = st.nextToken();
			for (int j = 5; j >= 1; j--) {
				temptable[i][j] = st.nextToken();
			}
		}
		int resultnum = 0;
		for (int i = 0; i < temptable.length; i++) {
			int tempnum = 0;
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < languages.length; k++) {
					if (temptable[i][j].equals(languages[k])) {
						tempnum += j * preference[k];
					}
				}
			}
			if (resultnum < tempnum) {
				resultnum = tempnum;
				answer = temptable[i][0];
			} else if (resultnum == tempnum && answer.compareTo(temptable[i][0]) > 0) {
				answer = temptable[i][0];
			}
		}
		System.out.println(answer);
	}
}
