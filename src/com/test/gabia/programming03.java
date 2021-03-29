package com.test.gabia;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class programming03 {
	private static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y > o.y) {
				return 1;
			} else if (this.y == o.y) {
				return this.x-o.x;
			}
			return -1;
		}

	}

	public static void main(String[] args) {
		int N = 3;
		int[] coffee_times = { 4, 2, 2, 5, 3 };
		int[] answer = new int[coffee_times.length];
		LinkedList<Point> arr = new LinkedList<Point>();
		for (int i = 0; i < coffee_times.length; i++) {
			arr.add(new Point(i + 1, coffee_times[i]));
		}
		PriorityQueue<Point> que = new PriorityQueue<Point>();
		List<Integer> result = new LinkedList<Integer>();

		while (result.size()<coffee_times.length) {
			while (que.size() < N) {
				if (arr.isEmpty()) {
					break;
				} else {
					que.add(arr.poll());
				}
			}
			Point p=que.poll();
			result.add(p.x);
			while(!que.isEmpty()&&(que.peek().y==p.y||que.peek().y-p.y<0)) {
				result.add(que.poll().x);
			}
			LinkedList<Point>templist=new LinkedList<Point>();
			while(!que.isEmpty()) {
				Point tempP=que.poll();
				tempP.y=tempP.y-p.y;
				templist.add(tempP);
			}
			while(!templist.isEmpty()) {
				que.add(templist.poll());
			}
			
		}
		for (int i = 0; i < answer.length; i++) {
			answer[i]=result.get(i);
		}
		System.out.println(Arrays.toString(answer));
	}
}
