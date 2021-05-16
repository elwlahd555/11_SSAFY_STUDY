package com.test.startup;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 프로그래밍02 {
	public static void main(String[] args) {
		int []t= {7,6,8,1};
		int r[]= {0,1,2,3};
		
		int[] answer = solution(t,r);
		System.out.println(Arrays.toString(answer));
	}
	private static class Point implements Comparable<Point>{
		int no,time,grade;

		public Point(int no, int time, int grade) {
			super();
			this.no = no;
			this.time = time;
			this.grade = grade;
		}

		@Override
		public int compareTo(Point o) {
			if(this.time==o.time) {
				return this.grade-o.grade;
			}
			return this.time-o.time;
		}
		
	}

	private static int[] solution(int[] t, int[] r) {
        LinkedList<Point> list=new LinkedList<>();
        for (int i = 0; i < t.length; i++) {
			list.add(new Point(i,t[i],r[i]));
		}
        Collections.sort(list);
        int[] answer = new int[list.size()];
        int n=0;
        while(!list.isEmpty()) {
        	Point p=list.poll();
        	while(list.peek()!=null&&list.peek().time==p.time) {
        		Point temp=list.poll();
        		temp.time=temp.time+1;
        		list.add(temp);
        	}
        	answer[n++]=p.no;
        	Collections.sort(list);
        }
        return answer;
	}
}
