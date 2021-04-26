package com.algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

public class 방문_길이 {
	public static void main(String[] args) {
		System.out.println(solution("LULLLLLLU"));
	}

	public static int solution(String dirs) {
		boolean[][][][] visitedPoint = new boolean[11][11][11][11];
		int[] moveX = { -1, 1, 0, 0 };
		int[] moveY = { 0, 0, 1, -1 };
		int answer = 0;

		int x = 5;
		int y = 5;
		int afterX = 5;
		int afterY = 5;
		int movingIndex = 0;

		for (int i = 0; i < dirs.length(); i++) {
			x = afterX;
			y = afterY;

			switch (dirs.charAt(i)) {
			case 'L':
				movingIndex = 0;
				break;
			case 'R':
				movingIndex = 1;
				break;
			case 'U':
				movingIndex = 2;
				break;
			case 'D':
				movingIndex = 3;
				break;
			}

			afterX += moveX[movingIndex];
			afterY += moveY[movingIndex];

			if (isNotValidPoint(afterX, afterY)) {
				afterX -= moveX[movingIndex];
				afterY -= moveY[movingIndex];
				continue;
			}

			if (!visitedPoint[x][y][afterX][afterY] && !visitedPoint[afterX][afterY][x][y]) {
				visitedPoint[x][y][afterX][afterY] = true;
				visitedPoint[afterX][afterY][x][y] = true;
				answer++;
			}
		}

		return answer;
	}

	public static boolean isNotValidPoint(int x, int y) {
		return (x < 0 || x > 10 || y < 0 || y > 10);
	}
}