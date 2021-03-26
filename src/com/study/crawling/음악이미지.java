package com.study.crawling;

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

public class 음악이미지 {
	public static void main(String[] args) throws Exception {
		String filePath = "C:/ssafy/title.txt";
		String filePath2 = "C:/ssafy/artist.txt";
		String line = "";
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		BufferedReader br;
		BufferedReader br2;
		try {
			br = new BufferedReader(new FileReader(filePath));
			br2 = new BufferedReader(new FileReader(filePath2));
			while ((line = br.readLine()) != null) {
				arr.add(line);
			}
			while ((line = br2.readLine()) != null) {
				arr2.add(line);
			}
			
// 	           System.out.println(new String(readBuffer,"UTF-8"));

			// 객체 사용을 다한 경우 스트림을 닫아준다
			br.close(); // 스트림 닫기
			br2.close(); // 스트림 닫기
			System.out.println(arr.size());
			System.out.println(arr2.size());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		File file = new File("C:\\ssafy\\musicimg.txt");

		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(file));

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i)+arr2.get(i));
			Connection.Response response = Jsoup.connect(
					"https://www.google.com/search?q="+arr.get(i)+" "+arr2.get(i)+"&sxsrf=ALeKk01i6whizldC27DY3jLVUiJnCEAUoA:1616727405386&source=lnms&tbm=isch&sa=X&ved=2ahUKEwi_4sj1-szvAhXjf94KHTlkBRwQ_AUoAXoECAEQAw&cshid=1616727572904169&biw=963&bih=897")
					.method(Connection.Method.GET).execute();
			Document Document = response.parse();
//			System.out.println(Document);
			Elements contents = Document.select("img");
//			System.out.println(contents);
			String s=contents.attr("data-src");
			System.out.println(s);
//			System.out.println(contents);
			bw.write(s);
			bw.newLine();
		}
		bw.close();

	}
}
