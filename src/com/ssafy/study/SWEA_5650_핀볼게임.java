package com.ssafy.study;

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA_5650_핀볼게임 {
	public static class Point {
		int x, y;

		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	private static int dx[] = { -1, 1, 0, 0 };
	private static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int temptempresult = 0;
					if (arr[i][j] == 0) {
						for (int k = 0; k < 4; k++) {
							LinkedList<Point> que = new LinkedList<>();

							int dxx=dx[k];
							int dyy=dy[k];
							que.add(new Point(i, j));
							arr[i][j]=-1;
							int cnt=0;
							while(!que.isEmpty()) {
								
								Point p=que.poll();
								int x=p.x+dxx;
								int y=p.y+dyy;
								if(x>=0&&x<N&&y>=0&&y<N&&arr[x][y]==-1) {
									break;
								}
								if((x<0&&y>=0&&y<N)||(x>=N&&y>=0&&y<N)) {
									cnt++;
									dxx*=-1;
									que.add(new Point(x,y));
								}else if((x<N&&x>=0&&y<0)||(y>=N&&x>=0&&x<N)) {
									cnt++;
									dyy*=-1;
									que.add(new Point(x,y));
								}else if(x>=0&&x<N&&y>=0&&y<N&&arr[x][y]>=6) {
									int temp=arr[x][y];
									for (int l = 0; l < N; l++) {
										for (int l2 = 0; l2 < N; l2++) {
											if(arr[l][l2]==temp&&(l!=x||l2!=y)) {
												que.add(new Point(l,l2));
											}
										}
									}
								}else if(x>=0&&x<N&&y>=0&&y<N&&arr[x][y]>=1&&arr[x][y]<=5) {
									cnt++;
									int temp=arr[x][y];
									switch(temp) {
									case 1:
										if((dxx==1&&dyy==0)||(dxx==0&&dyy==-1)) {
											int set=dxx;
											dxx=dyy;
											dyy=set;
										}else if(dxx==-1) {
											dxx*=-1;
										}else if(dyy==1) {
											dyy*=-1;
										}
										que.add(new Point(x,y));
										break;
									case 2:
										if((dxx==-1&&dyy==0)||(dxx==0&&dyy==-1)) {
											int set1=dxx;
											int set2=dyy;
											dxx=set2*-1;
											dyy=set1*-1;
										}else if(dxx==1) {
											dxx*=-1;
										}else if(dyy==1) {
											dyy*=-1;
										}
										que.add(new Point(x,y));
										break;
									case 3:
										if((dxx==-1&&dyy==0)||(dxx==0&&dyy==1)) {
											int set=dxx;
											dxx=dyy;
											dyy=set;
										}else if(dxx==1) {
											dxx*=-1;
										}else if(dyy==-1) {
											dyy*=-1;
										}
										que.add(new Point(x,y));
										break;
									case 4:
										if((dxx==1&&dyy==0)||(dxx==0&&dyy==1)) {
											int set1=dxx;
											int set2=dyy;
											dxx=set2*-1;
											dyy=set1*-1;
										}else if(dxx==-1) {
											dxx*=-1;
										}else if(dyy==-1) {
											dyy*=-1;
										}
										que.add(new Point(x,y));
										break;
									case 5:
	
										if(dyy==0) {
											dxx*=-1;
										}else if(dxx==0) {
											dyy*=-1;
										}
										que.add(new Point(x,y));
										break;
									}
								}else {
									que.add(new Point(x,y));
								}
								
							}
							if(temptempresult<cnt) {
								temptempresult=cnt;
							}
							arr[i][j]=0;
						}
					}else {
						continue;
					}
					if(temptempresult>result) {
						result=temptempresult;
					}
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
