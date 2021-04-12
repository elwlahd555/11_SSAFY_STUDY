package com.test.kakaocommerce;

public class programming02 {
	private static int check[];
	private static int answer;

	public static void main(String[] args) {
		int[][] needs = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 }, { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int r = 2;
		answer = 0;
		check = new int[r];
		dfs(0, 0, needs, r);
		System.out.println(answer);

	}

	private static void dfs(int cnt, int start, int[][] needs, int r) {
		if (cnt == r) {
			int tempresult = needs.length;
			int[][] temp = new int[needs.length][needs[0].length];
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[0].length; j++) {
					temp[i][j] = needs[i][j];
				}
			}
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < check.length; j++) {
					temp[i][check[j]] = 0;
				}
				for (int j = 0; j < temp[0].length; j++) {
					if (temp[i][j] == 1) {
						tempresult--;
						break;
					}
				}
			}
			if (tempresult > answer) {
				answer = tempresult;
			}
			return;
		}
		for (int i = start; i < needs[0].length; i++) {
			check[cnt] = i;
			dfs(cnt + 1, i + 1, needs, r);
		}
	}
}
//private int max, cNum;
//public int solution(int[][] needs, int r) {
//   max = Integer.MIN_VALUE;
//   cNum = needs[0].length; // 부품 종류의 갯수
//   
//   boolean[] visited = new boolean[cNum];
//   combination(needs,visited,0,cNum,r);
//   
//   System.out.println(max);
//   return max;
//}
//private void combination(int[][] needs,boolean[] visited, int start, int n, int r) {
//   if (r==0) {
//      // 해당 로봇을 사용했을 때 만들 수 있는 최대 완제품 수 구하기
//      max = Math.max(max, calc(needs,visited));
//      return;
//   }
//   
//   for (int i=start;i<n;i++) {
//      visited[i] = true;
//      combination(needs,visited,i+1,n,r-1);
//      visited[i] = false;
//   }
//}
//private int calc(int[][] needs, boolean[] visited) { // 해당 로봇을 구매했을 때 얻을 수 있는 갯수 구하기
//   int cnt = 0;
//   for (int[] need : needs) {
//      boolean flag = false;
//      for (int i = 0; i < need.length; i++) {
//         if (need[i] == 1 && !visited[i]) {
//            flag = true;
//            break;
//         } 
//      }
//      if (!flag) ++cnt;
//   }
//   
//   return cnt;
//}