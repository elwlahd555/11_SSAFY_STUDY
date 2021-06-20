package com.test.telentX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY related as parameter.
     */

    public static int countGroups(List<String> related) {
    	char arr[][]=new char[related.size()][related.size()];
    	int answer=0;
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr.length; j++) {
    			arr[i][j]=related.get(i).charAt(j);
			}
		}
    	LinkedList<Integer>que=new LinkedList<Integer>();
    	for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]=='1') {
					que.add(j);
				}
			}
			while(!que.isEmpty()) {
				int temp=que.poll();
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j]=='1') {
						que.add(j);
					}
					arr[temp][j]='0';
				}
			}
			answer++;
		}
		return answer;
    }


}
public class 연결된_그룹 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int relatedCount = Integer.parseInt(bufferedReader.readLine().trim());

//		List<String> related = IntStream.range(0, relatedCount).mapToObj(i -> {
//			try {
//				return bufferedReader.readLine();
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		}).collect(toList());
//
//		int result = Result.countGroups(related);
//
//		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
