package com.test.kakao2022;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 프로그래밍01 {
	public static void main(String[] args) {
		String[] id_list= {"muzi", "frodo", "apeach", "neo"};
		String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k=2;
		int result[]=solution(id_list,report,k);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	private static int[] solution(String[] id_list, String[] report, int k) {
		HashSet<String> set=new HashSet<String>();
		for (int i = 0; i < report.length; i++) {
			set.add(report[i]);
		}
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		LinkedList<LinkedList<String>> reportlist=new LinkedList<LinkedList<String>>();
		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], 0);
			reportlist.add(new LinkedList<String>());
		}
		for (String s : set) {
			StringTokenizer st=new StringTokenizer(s," ");
			String reporter=st.nextToken();
			String report_person=st.nextToken();
			for (int i = 0; i < id_list.length; i++) {
				if(id_list[i].equals(reporter)) {
					reportlist.get(i).add(report_person);
					break;
				}
			}
			map.replace(report_person, map.get(report_person)+1);
		}
		int answer[]=new int[id_list.length];
		for (int i = 0; i < reportlist.size(); i++) {
			for (int j = 0; j < reportlist.get(i).size(); j++) {
				if(map.get(reportlist.get(i).get(j))>=k) {
					answer[i]++;
				}
			}
		}
		return answer;
	}
}
