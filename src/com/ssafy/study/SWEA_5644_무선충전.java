package com.ssafy.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SWEA_5644_무선충전 {
	private static int dx[] = { 0, -1, 0, 1, 0 };
	private static int dy[] = { 0, 0, 1, 0, -1 };

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 10;
		int arr[][] = new int[N + 1][N + 1];
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int M = sc.nextInt();
			int A = sc.nextInt();
			int result[][] = new int[3][M + 1];
			int BC[][] = new int[A + 1][5];
			LinkedList<Point> queA = new LinkedList<>();
			LinkedList<Point> queB = new LinkedList<>();
			queA.add(new Point(1, 1));
			queB.add(new Point(10, 10));
			for (int i = 0; i < M; i++) {
				int temp = sc.nextInt();
				queA.add(new Point(queA.get(i).x + dx[temp], queA.get(i).y + dy[temp]));
			}
			for (int i = 0; i < M; i++) {
				int temp = sc.nextInt();
				queB.add(new Point(queB.get(i).x + dx[temp], queB.get(i).y + dy[temp]));
			}
//			for (int i = 0; i <= M; i++) {
//				System.out.println(queA.poll().x);
//			}
			List<List<Point>> BCque = new ArrayList<>();
			for (int i = 1; i <= A; i++) {
				List<Point> temp = new ArrayList<>();
				int y = sc.nextInt();
				int x = sc.nextInt();
				int C = sc.nextInt();
				int cnt = 0;
				for (int j = x - C; j <= x; j++) {
					for (int j2 = y - cnt; j2 <= y + cnt; j2++) {
						if (j > 0 && j <= N && j2 > 0 && j2 <= N) {
							temp.add(new Point(j, j2));
						}
					}
					cnt++;
				}
				cnt = cnt - 2;
				for (int j = x + 1; j <= x + C; j++) {
					for (int j2 = y - cnt; j2 <= y + cnt; j2++) {
						if (j > 0 && j <= N && j2 > 0 && j2 <= N) {
							temp.add(new Point(j, j2));
						}
					}
					cnt--;
				}
				BC[i][1] = sc.nextInt();
				BCque.add(temp);
			}
			while (!queA.isEmpty()) {
				int size = M+1 - queA.size();
				Point perA = queA.poll();
				Point perB = queB.poll();
				for (int i = 0; i < A; i++) {
					for (Point p : BCque.get(i)) {
						if (perA.x == p.x && perA.y == p.y) {
							BC[i + 1][2]++;
							BC[i + 1][3]++;
						}
					}
					for (Point p : BCque.get(i)) {
						if (perB.x == p.x && perB.y == p.y) {
							BC[i + 1][2]++;
							BC[i + 1][4]++;

						}
					}

				}
				int temptempcnt=0;
				int temptemptempcnt=0;
				for (int i = 1; i <= A; i++) {
					if(BC[i][2]==2) {
						temptempcnt++;
					}
					if(BC[i][3]==1) {
						temptemptempcnt++;
					}
				}
				int tempcnt=0;
				if(temptempcnt==1&&temptemptempcnt==2) {
					for (int i = 1; i <= A; i++) {
						int resultBC = 0;
						if (BC[i][2] ==1&&BC[i][3]==1) {
							resultBC = BC[i][1] / BC[i][3];
							if (result[1][size] < resultBC) {
								result[1][size] = resultBC;
								tempcnt=i;
							}
							
						}
					}
					
				}else if(temptempcnt==1&&temptemptempcnt==1){
					for (int i = 1; i <= A; i++) {
						int resultBC = 0;
						if (BC[i][2] ==2) {
							resultBC = BC[i][1];
								result[1][size] = resultBC;
								tempcnt=i;
								BC[i][4]=0;
							
						}
					}
				}else if(temptempcnt==2){
					for (int i = 1; i <= A; i++) {
						int resultBC = 0;
						if (BC[i][2] ==2) {
							resultBC = BC[i][1];

								result[1][size] = resultBC;
								tempcnt=i;
								BC[i][4]=0;
								break;
							
						}
					}
				}else {
					for (int i = 1; i <= A; i++) {
						int resultBC = 0;
						if (BC[i][3] > 0) {
							resultBC = BC[i][1] / BC[i][2];
							if (result[1][size] < resultBC) {
								result[1][size] = resultBC;
								tempcnt=i;
							}
							
						}
					}
					
				}
				for (int i = 0; i <= A; i++) {
					if(BC[i][3]>0&&tempcnt!=i) {
						BC[i][2]--;
					}
				}
				for (int i = 1; i <= A; i++) {
					if (BC[i][4] > 0) {
						int resultBC = BC[i][1] / BC[i][2];
						if (result[2][size] < resultBC) {
							result[2][size] = resultBC;
						}
						
					}
					
				}
				for (int i = 0; i <= A; i++) {
					for (int j = 2; j <= 4; j++) {
						BC[i][j] = 0;
					}
				}
			}

//			for (int i = 1; i <= 2; i++) {
//				for (int j = 0; j <= M; j++) {
//					System.out.print(result[i][j]+" ");
//				}
//				System.out.println();
//			}
			int sum=0;
			for (int i = 1; i <= 2; i++) {
				for (int j = 0; j <= M; j++) {
					sum+=result[i][j];
				}
			}
			System.out.println("#"+t+" "+sum);

		}
	}
}
