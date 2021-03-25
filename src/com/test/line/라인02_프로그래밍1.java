package com.test.line;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 라인02_프로그래밍1 {
	public static void main(String[] args) {
		String program = "line";
		String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
		String[] commands= {"line -n 100 -s hi -e", "lien -s Bye"};
		boolean[] answer = new boolean[commands.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i]=true;
		}
		String rules[][]=new String[flag_rules.length][2];
		for (int i = 0; i < rules.length; i++) {
			StringTokenizer st=new StringTokenizer(flag_rules[i]," ");
			for (int j = 0; j < 2; j++) {
				rules[i][j]=st.nextToken();
			}
		}
		for (int i = 0; i < answer.length; i++) {
			LinkedList<String> list=new LinkedList<String>();
			StringTokenizer st=new StringTokenizer(commands[i]," ");
			while(st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
			String temp=list.poll();
			if(!temp.equals(program)) {
				answer[i]=false;
				continue;
			}

			while(!list.isEmpty()&&answer[i]) {
				String flag=list.poll();
				if(flag.equals("-e")) {
					if(!list.isEmpty()) {
						answer[i]=false;
						break;
					}
				}else if(flag.equals("-n")) {
					char temparr[]=list.poll().toCharArray();
					for (int j = 0; j < temparr.length; j++) {
						if(temparr[i]<'0'||temparr[i]>'9') {
							answer[i]=false;
							break;
						}
					}
					
				}else if(flag.equals("-s")) {
					char temparr[]=list.poll().toLowerCase().toCharArray();
					for (int j = 0; j < temparr.length; j++) {
						if(temparr[i]<'a'||temparr[i]>'z') {
							answer[i]=false;
							break;
						}
					}
				}else {
					answer[i]=false;
				}
				
			}
		}
		System.out.println(Arrays.toString(answer));
	}

}
