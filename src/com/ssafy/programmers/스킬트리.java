package com.ssafy.programmers;

public class 스킬트리 {
	public static void main(String[] args) {
		String skill = "CBDK";
		String[] skill_trees = { "CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK" };
		int answer = skill_trees.length;

		for (int i = 0; i < skill_trees.length; i++) {
			char temp[] = skill_trees[i].toCharArray();
			int arr[] = new int[temp.length];
			int tempnum = 0;
			for (int j = 0; j < temp.length; j++) {
				arr[j] = skill.indexOf(temp[j]);
				if (arr[j] > tempnum) {
					tempnum = arr[j];
				}
			}
			for (int j = arr.length - 1; j >= 0; j--) {
				if (arr[j] >= 0 && arr[j] < tempnum && arr[j] != tempnum - 1) {
					break;
				} else if (arr[j] >= 0 && arr[j] < tempnum && arr[j] == tempnum - 1) {
					tempnum--;
				} else if (arr[j] > tempnum) {
					tempnum = 10;
					break;
				}
			}
			if (tempnum != 0) {
				answer--;
			}

		}
		System.out.println(answer);

	}
}
