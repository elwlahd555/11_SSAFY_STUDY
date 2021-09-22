package com.test.telentX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Result02 {

	/*
	 * Complete the 'groupTransactions' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * STRING_ARRAY transactions as parameter.
	 */

	public static List<String> groupTransactions(List<String> transactions) {

		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (String ts : transactions) {
			if (map.containsKey(ts)) {
				map.replace(ts, map.get(ts) + 1);
			} else {
				map.put(ts, 1);
			}
		}
		Map<String, Integer> sort_map = map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1 > o2 ? -1 : 0;
					}
				}))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		List<String> result = new ArrayList<String>();
		for (String s : sort_map.keySet()) {
			result.add(s + " " + sort_map.get(s));
		}
		return result;

	}
}

public class 품목명별로_거래_그룹화 {
	public void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int transactionsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> transactions = new ArrayList<>();

		for (int i = 0; i < transactionsCount; i++) {
			String transactionsItem = bufferedReader.readLine();
			transactions.add(transactionsItem);
		}

//		List<String> result = Result.groupTransactions(transactions);
//
//		for (int i = 0; i < result.size(); i++) {
//			bufferedWriter.write(result.get(i));
//
//			if (i != result.size() - 1) {
//				bufferedWriter.write("\n");
//			}
//		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
