package com.algorithm.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2115_벌꿀채취 {
	private static int N,M,C,tempsum;
	private static int arr[][];
	private static int result[][];
	private static int resultlast[][];
	private static boolean visit[][];
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			C=sc.nextInt();
			arr=new int[N][N];
			result=new int[N][N];
			visit=new boolean[N][N];
			resultlast=new int[N][N];
			temp=new int[M];
			temptemp=new int[M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]=sc.nextInt();
				}
				
			}
			find();
			int num=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N-M; j++) {
					for (int k = j-M+1; k < j+M; k++) {
						if(k>=0&&k<N) {
							visit[i][k]=true;
						}
					}
					resultlast[i][j]=result[i][j]+high();
					for (int k = j-M+1; k < j+M; k++) {
						if(k>=0&&k<N) {
							visit[i][k]=false;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N-M; j++) {
					if(num<resultlast[i][j]) {
						num=resultlast[i][j];
					}
				}
				
			}
			for (int i = 0; i < N; i++) {
				
//				System.out.println(Arrays.toString(result[i]));
//				System.out.println(Arrays.toString(resultlast[i]));
			}
			System.out.println("#"+t+" "+num);
		}
	}

	private static int high() {
		// TODO Auto-generated method stub
		int num=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				if(!visit[i][j]&&result[i][j]>num) {
					num=result[i][j];
				}
			}
			
		}
		return num;
	}

	private static void find() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				pow(i,j,0,0);
			}
		}
	}
	private static int temp[];
	private static void pow(int i, int j,int cnt,int start) {
		// TODO Auto-generated method stub
		if(cnt==M) {
			int sum=0;
			int sumpow=0;
			for (int k = 0; k < M; k++) {
				sum+=temp[k];
				sumpow+=Math.pow(temp[k], 2);
			}
//			System.out.println(sum);
			if(sum<=C) {
				result[i][j]=sumpow;
			}else{
				tempsum=0;
				sumpow(0,0);
				result[i][j]=tempsum;
				
			}
			return;
		}
		for (int k = start; k < M; k++) {
			temp[cnt]=arr[i][j+k];
			pow(i,j,cnt+1,k+1);
		}
	}
private static int temptemp[];
	private static void sumpow(int cnt,int start) {
		// TODO Auto-generated method stub
		if(cnt==M) {
			int sum=0;
			int sumpow=0;
			for (int i = 0; i < M; i++) {
				sum+=temptemp[i];
				sumpow+=Math.pow(temptemp[i], 2);
			}
			if(sum<=C&&tempsum<sumpow) {
				tempsum=sumpow;
			}
			
			
		}
		for (int i = start; i < M; i++) {
			temptemp[cnt]=temp[i];
			sumpow(cnt+1,i+1);
			temptemp[cnt]=0;
			sumpow(cnt+1,i+1);
		}
		
	}
}
