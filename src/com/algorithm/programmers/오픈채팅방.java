package com.algorithm.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class 오픈채팅방 {
	public static void main(String[] args) {
		String record[] = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String answer[] = solution(record);
		System.out.println(Arrays.toString(answer));
	}

	private static String[] solution(String[] record) {
		ArrayList<String> arr = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			String[] command = record[i].split(" ");

			if (command[0].equals("Enter")) {
				arr.add(command[1] + "님이 들어왔습니다.");
				map.put(command[1], command[2]);
			} else if (command[0].equals("Change")) {
				map.put(command[1], command[2]);
			} else {
				arr.add(command[1] + "님이 나갔습니다.");
			}
		}
		String[] answer = new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			int idx = arr.get(i).indexOf("님");
			String id = arr.get(i).substring(0, idx);
			String[] temp = arr.get(i).split(" ");
			answer[i] = map.get(id) + "님이 " + temp[1];
		}
		return answer;
	}
}
