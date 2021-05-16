package com.test.startup;

import java.util.Collections;
import java.util.LinkedList;

public class 프로그래밍1 {
	private static class Point implements Comparable<Point>{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return this.x-o.x;
		}
		
	}
	public static void main(String[] args) {
		String code="012345";
		String day="20190620";
		String[] data= {"price=80 code=987654 time=2019062113","price=90 code=012345 time=2019062014","price=120 code=987654 time=2019062010","price=110 code=012345 time=2019062009","price=95 code=012345 time=2019062111"};
		int[] answer = solution(code,day,data);
	}

	private static int[] solution(String code, String day, String[] data) {
        LinkedList<Point>result=new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
			String dataarr[]=data[i].split(" ");
			if(dataarr[1].substring(5).contentEquals(code)&&dataarr[2].substring(5,13).equals(day)) {
				result.add(new Point(Integer.parseInt(dataarr[2].substring(13)), Integer.parseInt(dataarr[0].substring(6))));
			}
		}
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
        	answer[i]=result.get(i).y;
		}
        
        
        return answer;
	}
}
