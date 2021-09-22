package com.test.kakao2022;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 프로그래밍03 {
	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		int result[] = solution(fees, records);
		for (int i = 0; i < result.length; i++) {
			System.err.println(result[i]);
		}
	}

	private static int[] solution(int[] fees, String[] records) {
		TreeMap<String, Integer> number_map = new TreeMap<String, Integer>();
		HashMap<String, LinkedList<String>> record_map = new HashMap<String, LinkedList<String>>();
		for (int i = 0; i < records.length; i++) {
			StringTokenizer st = new StringTokenizer(records[i], " ");
			String time = st.nextToken();
			String number = st.nextToken();
			String type = st.nextToken();
			if (!record_map.containsKey(number)) {
				record_map.put(number, new LinkedList<String>());
			}
			record_map.get(number).add(time);
		}
		for (String s : record_map.keySet()) {
			if(record_map.get(s).size()%2==1) {
				record_map.get(s).add("23:59");
			}
			if(!number_map.containsKey(s)) {
				number_map.put(s, 0);
			}
			for (int i = 0; i < record_map.get(s).size(); i+=2) {
				StringTokenizer st_in=new StringTokenizer(record_map.get(s).get(i),":");
				StringTokenizer st_out=new StringTokenizer(record_map.get(s).get(i+1),":");
				int hour=Integer.parseInt(st_out.nextToken())-Integer.parseInt(st_in.nextToken());
				int min=Integer.parseInt(st_out.nextToken())-Integer.parseInt(st_in.nextToken());
				number_map.replace(s, number_map.get(s)+hour*60+min);
			}
		}
		int answer[]=new int[number_map.size()];
		int cnt=0;
		for (String s : number_map.keySet()) {
			int time=number_map.get(s);
			if(time<fees[0]) {
				answer[cnt]=fees[1];
			}else {
				int time_set=(time-fees[0])/fees[2];
				if((time-fees[0])%fees[2]!=0){
					time_set++;
				}
				answer[cnt]=fees[1]+time_set*fees[3];
			}
			cnt++;
		}
		return answer;
	}
}
