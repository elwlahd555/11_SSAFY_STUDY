package com.test.line;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 라인02_프로그래밍3 {
	private static class Alias{
		String x,y;

		public Alias(String x, String y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) {
		String program = "bank";
		String[] flag_rules = { "-send STRING", "-a ALIAS -amount", "-amount NUMBERS" };
		String[] commands = { "bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey" };
		boolean[] answer = new boolean[commands.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = true;
		}
		LinkedList<Alias>alias=new LinkedList<Alias>();
		String rules[][] = new String[flag_rules.length][2];
		
		for (int i = 0; i < rules.length; i++) {
			StringTokenizer st = new StringTokenizer(flag_rules[i], " ");
			for (int j = 0; j < 2; j++) {
				rules[i][j] = st.nextToken();
				if (rules[i][j].equals("ALIAS")) {
					rules[i][j] = st.nextToken();
					alias.add(new Alias(rules[i][0],rules[i][1]));
				}
			}
		}
		for (int i = 0; i < rules.length; i++) {
			String rule = rules[i][1];
			for (int j = 0; j < rules.length; j++) {
				if (rule.equals(rules[j][0])) {
					rules[i][1] = rules[j][1];
					break;
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			LinkedList<String> list = new LinkedList<String>();
			StringTokenizer st = new StringTokenizer(commands[i], " ");
			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
			int size=alias.size();
			for (int j = 0; j < size; j++) {
				if(list.contains(alias.get(j).x)) {
					if(list.contains(alias.get(j).y)) {
						answer[i]=false;
						continue;
					}
				}
			}
			String temp = list.poll();
			if (!temp.equals(program)) {
				answer[i] = false;
				continue;
			}

			while (!list.isEmpty() && answer[i]) {
				String flag = list.poll();
				boolean flagcheck = false;
				int flagnum = 0;
				for (int j = 0; j < rules.length; j++) {
					if (rules[j][0].equals(flag)) {
						flagcheck = true;
						flagnum = j;
						break;
					}
				}
				if (flagcheck) {

					if (rules[flagnum][1].equals("NUMBER")) {
						char temparr[] = list.poll().toCharArray();
						for (int k = 0; k < temparr.length; k++) {
							if (temparr[k] < '0' || temparr[k] > '9') {
								answer[i] = false;
								break;
							}
						}
					} else if (rules[flagnum][1].equals("NUMBERS")) {
						while (!list.isEmpty()) {
							String checknext = list.get(0);
							if (check(checknext, rules)) {
								char temparr[] = list.poll().toCharArray();
								for (int k = 0; k < temparr.length; k++) {
									if (temparr[k] < '0' || temparr[k] > '9') {
										answer[i] = false;
										break;
									}
								}
							} else {
								break;
							}

						}
					} else if (rules[flagnum][1].equals("STRING")) {
						char temparr[] = list.poll().toLowerCase().toCharArray();
						for (int k = 0; k < temparr.length; k++) {
							if (temparr[k] < 'a' || temparr[k] > 'z') {
								answer[i] = false;
								break;
							}
						}
					} else if (rules[flagnum][1].equals("STRINGS")) {
						while (!list.isEmpty()) {
							String checknext = list.get(0);
							if (check(checknext, rules)) {
								char temparr[] = list.poll().toLowerCase().toCharArray();
								for (int k = 0; k < temparr.length; k++) {
									if (temparr[k] < 'a' || temparr[k] > 'z') {
										answer[i] = false;
										break;
									}
								}
							} else {
								break;
							}
						}

					} else if (rules[flagnum][0].equals("NULL")) {
						if (!list.isEmpty()) {
							answer[i] = false;
							break;
						}
					}
				} else {
					answer[i] = false;
				}
			}
		}
		System.out.println(Arrays.toString(answer));
	}

	private static boolean check(String s, String[][] rules) {
		for (int i = 0; i < rules.length; i++) {
			if (rules[i][0].equals(s)) {
				return false;
			}
		}

		return true;
	}

}
