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

public class 음악 {
	public static void main(String[] args) throws IOException {
		String filePath = "C:/ssafy/music.txt";
		String line = "";
		ArrayList<String> arr = new ArrayList<String>();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(filePath));
			while ((line = br.readLine()) != null) {
				arr.add(line);
			}
//	           System.out.println(new String(readBuffer,"UTF-8"));

			// 객체 사용을 다한 경우 스트림을 닫아준다
			br.close(); // 스트림 닫기
			System.out.println(arr.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		File file = new File("C:\\ssafy\\music01.txt");

		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(file));
		
		for (int i = 0; i < 1; i++) {
			System.out.println(arr.get(i));
			Connection.Response response = Jsoup.connect(
					"https://www.youtube.com/results?search_query="+arr.get(i))
					.method(Connection.Method.GET).execute();
			Document Document = response.parse();
//			System.out.println(Document);
			Elements contents = Document.select("h3");
			System.out.println(Document.text());
//			for (Element e : li) {
//				Elements a=e.select("a");
//				String href=a.attr("href");
//				String detail=e.select("a.spot-cat3-item").text();
//				String title=e.select("h4.spot-name").text();
//				System.out.println(title);
//				System.out.println(detail);
//				
//				Connection.Response response02 = Jsoup.connect("https://www.wishbeen.co.kr"+href)
//						.method(Connection.Method.GET).execute();
//				Document Document02 = response02.parse();
//				Elements imgtemp=Document02.select("div>img");
//				String img=imgtemp.select("img.carousel-image").attr("src");
//
//				System.out.println(img);
//
//			}
		}
		bw.close();

	}
}
