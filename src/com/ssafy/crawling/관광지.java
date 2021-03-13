package com.ssafy.crawling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 관광지 {
	public static void main(String[] args) throws IOException {
		String filePath = "C:/ssafy/temptemp.txt";

		// 파일을 읽어오기 위한 FileInputStream 객체 선언

		// FileInputStream에 읽어올 파일 경로 지정 실시

		String line = "";
		ArrayList<String> arr = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				arr.add(line);
			}
//           System.out.println(new String(readBuffer,"UTF-8"));

			// 객체 사용을 다한 경우 스트림을 닫아준다
			System.out.println(arr.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		br.close(); // 스트림 닫기

		File file = new File("C:\\ssafy\\test07.txt");

		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(file));
		int no = 0;
		while (no < 74) {
			System.out.println(arr.get(no));
			Connection.Response response = Jsoup.connect(
					"https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=2&acq="+arr.get(no)+"&qdt=0&ie=utf8&query="+arr.get(no))
					.method(Connection.Method.GET).execute();
			Document Document = response.parse();
			
//			System.out.println(Document);
			
			Elements add=Document.select("span.addr");
			System.out.println(add.text());



			bw.write(add.text());
			bw.newLine();
			
			no++;

		}
		bw.close();
	}
}
