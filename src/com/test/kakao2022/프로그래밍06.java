package com.test.kakao2022;

import java.util.ArrayList;

public class 프로그래밍06 {
	public static void main(String[] args) {
		int [][]board= {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int [][]skill= {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		
		System.out.println(solution(board,skill));
		
	}

	private static int solution(int[][] board, int[][] skill) {
		int answer=0;
		ArrayList<Integer> temp=new ArrayList<Integer>();
		for (int i = 0; i < skill.length; i++) {
			if(skill[i][0]==1) {
				
				for (int j = skill[i][1]; j <= skill[i][3]; j++) {
					for (int j2 = skill[i][2]; j2 <= skill[i][4]; j2++) {
						board[j][j2]-=skill[i][5];
					}
				}
			}else {
				for (int j = skill[i][1]; j <= skill[i][3]; j++) {
					for (int j2 = skill[i][2]; j2 <= skill[i][4]; j2++) {
						board[j][j2]+=skill[i][5];
					}
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j]>0) {
					answer++;
				}
			}
		}
		return answer;
	}
}
