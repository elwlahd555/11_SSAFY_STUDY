package com.algorithm.BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 모노미노도미노2 {
	private static int green[][];
	private static int blue[][];
	private static int score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		green=new int[6][4];
		blue=new int[6][4];
		for (int n = 0; n < N; n++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			change_green(t,x,y);
			change_blue(t,x,y);
			clear_green();
			clear_blue();
			int ck_green=check_green();
			while(ck_green<2) {
				for (int i = 4; i >= 0; i--) {
					green[i+1]=green[i];
				}
				green[0]=new int[4];
				ck_green++;
			}
			int ck_blue=check_blue();
			while(ck_blue<2) {
				for (int i = 4; i >= 0; i--) {
					blue[i+1]=blue[i];
				}
				blue[0]=new int[4];
				ck_blue++;
			}
		}
		int answer=0;
		for (int i = 0; i < green.length; i++) {
			for (int j = 0; j < green[0].length; j++) {
				if(green[i][j]==1) {
					answer++;
				}
				if(blue[i][j]==1) {
					answer++;
				}
			}
		}
		System.out.println(score);
		System.out.println(answer);
	}

	private static void clear_green() {
		for (int i = 0; i < green.length; i++) {
			int check=0;
			for (int j = 0; j < green[0].length; j++) {
				if(green[i][j]==1) {
					check++;
				}
			}
			if(check==4) {
				score++;
				for (int j = i-1; j >=0; j--) {
					green[j+1]=green[j];
				}
				green[0]=new int[4];
			}
		}
	}
	private static void clear_blue() {
		for (int i = 0; i < green.length; i++) {
			int check=0;
			for (int j = 0; j < green[0].length; j++) {
				if(blue[i][j]==1) {
					check++;
				}
			}
			if(check==4) {
				score++;
				for (int j = i-1; j >=0; j--) {
					blue[j+1]=blue[j];
				}
				blue[0]=new int[4];
			}
		}
	}

	private static int check_green() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < green[0].length; j++) {
				if(green[i][j]==1) {
					return i;
				}
			}
		}
		return 2;
	}
	private static int check_blue() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < blue[0].length; j++) {
				if(blue[i][j]==1) {
					return i;
				}
			}
		}
		return 2;
	}

	private static void change_green(int t, int x, int y) {
		if(t==1) {
			for (int i = 0; i < green.length; i++) {
				if(green[i][y]==1) {
					green[i-1][y]=1;
					return;
				}
			}
			green[5][y]=1;
		}else if(t==2) {
			for (int i = 0; i < green.length; i++) {
				if(green[i][y]==1||green[i][y+1]==1) {
					green[i-1][y]=1;
					green[i-1][y+1]=1;
					return;
				}
			}
			green[5][y]=1;
			green[5][y+1]=1;
		}else {
			for (int i = 0; i < green.length; i++) {
				if(green[i][y]==1) {
					green[i-1][y]=1;
					green[i-2][y]=1;
					return;
				}
			}
			green[5][y]=1;
			green[4][y]=1;
		}
	}
	private static void change_blue(int t, int x, int y) {
		if(t==1) {
			for (int i = 0; i < green.length; i++) {
				if(blue[i][x]==1) {
					blue[i-1][x]=1;
					return;
				}
			}
			blue[5][x]=1;
		}else if(t==3) {
			for (int i = 0; i < green.length; i++) {
				if(blue[i][x]==1||blue[i][x+1]==1) {
					blue[i-1][x]=1;
					blue[i-1][x+1]=1;
					return;
				}
			}
			blue[5][x]=1;
			blue[5][x+1]=1;
		}else {
			for (int i = 0; i < green.length; i++) {
				if(blue[i][x]==1) {
					blue[i-1][x]=1;
					blue[i-2][x]=1;
					return;
				}
			}
			blue[5][x]=1;
			blue[4][x]=1;
		}
	}
}
