package com.algorithm.programmers;

public class 문자열내p와y의개수 {
	public static void main(String[] args) {
		String s="pPoooyY";
		char[] schar=s.toLowerCase().toCharArray();
		int psize=0;
		int ysize=0;
		boolean answer = true;
		for (int i = 0; i < schar.length; i++) {
			if(schar[i]=='p') {
				psize++;
			}else if(schar[i]=='y') {
				ysize++;
			}
		}
		if(psize==ysize) {
			answer=true;
		}else {
			answer=false;
		}
		System.out.println(answer);
	}
}
