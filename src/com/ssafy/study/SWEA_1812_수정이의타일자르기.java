package com.ssafy.study;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1812_수정이의타일자르기 {
	
	static class Rectangle implements Comparable<Rectangle>{
		int max, min;
		public Rectangle(int width, int height) {
			min =Math.min(width, height);
			max = Math.max(width, height);
		}
		@Override
		public int compareTo(Rectangle o) {
			// TODO Auto-generated method stub
			return o.min - this.min;
		}
	}
	static int N,M,size[],cnt;
	static PriorityQueue<Rectangle> que;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			size=new int[N];
			cnt=0;
			for (int i = 0; i < N; i++) {
				size[i]=sc.nextInt();
			}
			cut();
			System.out.println("#"+t+" "+cnt);
		}
	}
	private static void cut() {
		// 만들고자 하는 크기가 큰 타일부터 처리
		Arrays.sort(size);
		que=new PriorityQueue<Rectangle>();
		que.add(new Rectangle(M, M));
		++cnt;
		for (int i = N-1; i >=0 ; i--) {
			go(1<<size[i]); //1 1<<1 : 10(2), 1<<2 : 100(4)
			
		}
		
	}
	private static void go(int size) {
		// TODO Auto-generated method stub
		// 자투리 타일중에 min 변의 크기가 최대인 애 꺼내서 비교
		Rectangle r=que.poll();
		
		// 원하는 크기의 타일을 만들수 있다면 만들고 잘라낸 2개의 자투리 타일을 다시 보관
		if(r.min>=size) {
			que.add(new Rectangle(r.min-size, size));
			que.add(new Rectangle(r.min,r.max-size));
		}else {
			
		
		// 원하는 크기의 타일을 만들수 없다면 새로 타일을 구매해서 잘라내고(이때, 구매한 타일 개수 카운트 증가)
		// 원하는 크기의 타일을 만들수 없다면 잘라낸 2개의 자투리 타일을 다시 보관
		// 원하는 크기의 타일을 만들수 없다면 꺼내고 사용하지 않은 타일 다시 보관
		++cnt;
		que.add(r);
		que.add(new Rectangle(M-size, size));
		que.add(new Rectangle(M-size, M));
		
		}
	}
}
