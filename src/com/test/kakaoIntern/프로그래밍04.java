package com.test.kakaoIntern;

import java.util.LinkedList;

public class 프로그래밍04 {
	public static void main(String[] args) {
		int n = 4;
		int start = 1;
		int end = 4;
		int[][] roads = { { 1, 2, 1 }, { 3, 2, 1 },{2,4,1} };
		int[] traps = { 2,3 };
		int answer = solution(n, start, end, roads, traps);
		System.out.println(answer);
	}

	private static class Point {
		int node;
		int result;
		int arr[][];
		public Point(int node, int result, int[][] arr) {
			super();
			this.node = node;
			this.result = result;
			this.arr = arr;
		}


	}

	private static int solution(int n, int start, int end, int[][] roads, int[] traps) {
		int answer = Integer.MAX_VALUE;
		int arr[][] = new int[n + 1][n + 1];
		for (int i = 0; i < roads.length; i++) {
			arr[roads[i][0]][roads[i][1]] = roads[i][2];
		}
		LinkedList<Point> que = new LinkedList<>();
		que.add(new Point(start, 0,arr));
		int cnt=0;
		while (!que.isEmpty()) {
			if(cnt>10) {
				break;
			}
			int size = que.size();
			for (int k = 0; k < size; k++) {
				Point p = que.poll();
				if(p.node==end) {
					answer=Math.min(p.result, answer);
					cnt++;
					continue;
				}
				int temparr[][]=clone(p.arr);
				for (int i = 0; i < temparr.length; i++) {
					if (temparr[p.node][i] > 0) {
						int num=temparr[p.node][i];
						if (check(i, traps)) {
							for (int j = 0; j < temparr.length; j++) {
								if (p.arr[j][i] > 0) {
									temparr[i][j] = temparr[j][i];
									temparr[j][i] = 0;
								}
							}
							for (int j = 0; j < temparr.length; j++) {
								if (p.arr[i][j] > 0) {
									temparr[j][i] = temparr[i][j];
									temparr[i][j] = 0;
								}
							}
						}
						que.add(new Point(i, p.result + num,temparr));
						temparr=clone(p.arr);
					}
				}
			}
		}

		return answer;
	}

	private static int[][] clone(int[][] arr) {
		int temp[][]=new int[arr.length][arr.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j]=arr[i][j];
			}
		}
		return temp;
	}

	private static boolean check(int i, int[] traps) {
		for (int j = 0; j < traps.length; j++) {
			if (traps[j] == i) {
				return true;
			}
		}
		return false;
	}
}
