package com.algorithm.programmers;

public class 프로그래밍1_210909 {
	public static void main(String[] args) {
		int[] numbers= {1,2,3,4,6,7,8,0};
		System.out.println(solution(numbers));
	}

	private static int solution(int[] numbers) {
		int answer=0;
		int check[]=new int[10];
		for (int i = 0; i < numbers.length; i++) {
			check[numbers[i]]=1;
		}
		for (int i = 0; i < check.length; i++) {
			if(check[i]==0) {
				answer+=i;
			}
		}
		return answer;
	}
}
