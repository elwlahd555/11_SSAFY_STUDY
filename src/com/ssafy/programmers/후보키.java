package com.ssafy.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 후보키 {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		String[][] relation= {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		ArrayList<String[]> rel=new ArrayList<String[]>();
		
		int N=relation.length;
		int M=relation[0].length;
		for (int j = 0; j < M; j++) {
			String []temp=new String[N];
			for (int i = 0; i < N; i++) {
				temp[i]=relation[i][j];
			}
			rel.add(temp);
		}
		ArrayList<Integer> arr=new ArrayList<>();
		int size=0;
		while(!rel.isEmpty()) {
			size++;
			for (int j = 0; j < M; j++) {
				Set<String> set=new HashSet<String>();
				for (int i = 0; i < N; i++) {
					set.add(relation[i][j]);
				}
				if(set.size()==N) {
					arr.add(j);
				}
			}
			for (int i = arr.size()-1; i >=0; i--) {
				rel.remove(arr.get(i));
			}
			
		}
		
	}
}
