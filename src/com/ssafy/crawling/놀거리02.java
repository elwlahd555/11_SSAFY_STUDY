package com.ssafy.crawling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class 놀거리02 {

	public static void main(String[] args) throws IOException {

      String filePath = "C:/ssafy/123123.txt";
      
      //파일을 읽어오기 위한 FileInputStream 객체 선언
      
      
      //FileInputStream에 읽어올 파일 경로 지정 실시

   String line = "";
   String result ="";
      BufferedReader br;
      StringBuilder sb = new StringBuilder();
      try {
         br = new BufferedReader(new FileReader(filePath));
         while((line=br.readLine())!=null) {
//        	System.out.println(line);
            sb.append(line);
         }
//           System.out.println(new String(readBuffer,"UTF-8"));
           
           //객체 사용을 다한 경우 스트림을 닫아준다
           br.close(); //스트림 닫기
//           System.out.println(sb);
           result=sb.toString();
//           System.out.println(result);
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();

      }
		
		File file = new File("C:\\ssafy\\test04.txt");

		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(file));
		int no = 3;
		while (no <= 3) {

//			Connection.Response response = Jsoup.connect(
//					"https://m.map.naver.com/search2/searchMore.naver?query=%EB%8C%80%EA%B5%AC%20%EB%8B%B9%EA%B5%AC%EC%9E%A5&sm=clk&style=v5&page=1&displayCount=75&type=SITE_1")
//					.method(Connection.Method.GET).execute();
//			Document Document = response.parse();
//			
//			
//			Elements ul = Document.select("addr");
//			System.out.println(Document.text());
			
			JSONParser parser = new JSONParser();
			
			 JSONObject obj = null;
	           
	           try {
	                obj = (JSONObject)parser.parse(result);
	                System.out.println(obj);

	           } catch (ParseException e) {
	                System.out.println("변환에 실패");
	                e.printStackTrace();
	           }


//			System.out.println(ul);
//			System.out.println(ul);
//			System.out.println(Document.toString().substring(Document.toString().indexOf("var searchResult"), Document.toString().indexOf("var searchResult")+100));

//			bw.write(title + "!관광지!" + detail + "!"  + "!" + "!" + "!!!" + img);
//			bw.newLine();

			
			no++;

		}
		bw.close();

	}
}