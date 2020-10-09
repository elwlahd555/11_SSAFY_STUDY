package com.ssafy.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	
	static int[][] arr;
	static int N, X, T, result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			result = 0;
			
			for(int i = 0 ; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j < N ; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0 ; i < N ; i++) {

					if(canConstruct(i, true)) {
						result++;
					}
					if(canConstruct(i, false)) {
						result++;
					}
				
			}
			
			System.out.println("#" + t + " " + result);
		}
	}

	private static boolean canConstruct(int idx, boolean type) {
		boolean[] visited = new boolean[N];
		int cnt = 0;
		int before = -1;
		
		if(type) {
			before = arr[idx][0];
			
			for(int i = 0 ; i < N ; i++) {
				int cur = arr[idx][i];
				
				if(cur == before) {
					cnt++;
				} else {
					if(cur == before + 1) { // 지대가 높아지는 경우 
						if(cnt >= X) {
							for(int j = i - X ; j < i ; ++j) {
								if(visited[j]) return false;
								visited[j] = true;
							}
							cnt = 1;
						} else {
							return false;
						}
					} else if(cur == before - 1) {// 지대가 낮아지는 경우
						if(i + X - 1 < N) {
							for(int j = i ; j < i + X ; j++) {
								if(visited[j] || arr[idx][j] != cur) return false;
								visited[j] = true;
							}
							cnt = 0;
							i = i + X - 1;
						} else {
							return false;
						}
					} else {
						return false;
					}
					before = cur;
				}
			}
		} else {
			before = arr[0][idx];
			
			for(int i = 0 ; i < N ; i++) {
				int cur = arr[i][idx];
				
				if(cur == before) {
					cnt++;
				} else {
					if(cur == before + 1) {// 지대가 높아지는 경우 
						if(cnt >= X) {
							for(int j = i - X ; j < i ; j++) {
								if(visited[j]) return false;
								visited[j] = true;
							}
							cnt = 1;
						} else {
							return false;
						}
					} else if(cur == before - 1) {// 지대가 낮아지는 경우
						if(i + X - 1 < N) {
							for(int j = i ; j < i + X ; j++) {
								if(visited[j] || arr[j][idx] != cur) return false;
								visited[j] = true;
							}
							i = i + X - 1;
							cnt = 0;
						} else {
							return false;
						}
					} else {
						return false;
					}
					before = cur;
				}
			}
		}
		
		return true;
	}
}