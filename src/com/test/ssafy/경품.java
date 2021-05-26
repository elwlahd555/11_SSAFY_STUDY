package com.test.ssafy;

/*

3명의 친구들이 경품들 중 각각 하나씩을 가져가려고 한다
경품은 일렬로 N개가 놓여 있고 각각의 가치가 표시되어 있다.
규칙 상 연속된 3개의 경품을 가져가야 한다.
3명의 친구들은 가장 공평한 것을 원하기 때문에 3개 경품의 가치가 각각 A,B,C일때
|A-B|+|B-C|+|C-A|의 값이 가장 작은 경우를 택하려고 한다.
가능한 가장 작은 |A-B|+|B-C|+|C-A|의 값을 계산하라.

예제1입력)
N=5,{9,7,1,5,4};

8

 */
public class 경품 {
	private static int arr[] = { 10, 5, 4, 8, 1, 6, 9 };
	private static int answer = Integer.MAX_VALUE;
	private static int N;

	public static void main(String[] args) {
		N = 7;
		for (int i = 0; i < N - 2; i++) {
			int num = Math.abs(arr[i] - arr[i + 1]) + Math.abs(arr[i + 1] - arr[i + 2]) + Math.abs(arr[i + 2] - arr[i]);
			answer = Math.min(answer, num);
		}
		System.out.println(answer);
	}
}
