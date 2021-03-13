package com.ssafy.crawling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 즐길거리 {
	public static void main(String[] args) throws IOException {
		
			
			File file = new File("C:\\ssafy\\test06.txt");

			BufferedWriter bw;
			bw = new BufferedWriter(new FileWriter(file));
			int no = 1;
			while (no <= 1) {

				Connection.Response response = Jsoup.connect(
						"https://www.wishbeen.co.kr/city?serviceType=daegu&tab=attraction&cat2=4776069797704a8d&viewPageNum=1&perPage=100")
						.method(Connection.Method.GET).execute();
				Document Document = response.parse();
//				System.out.println(Document);
				Elements in = Document.select("div.inner-box");
//				System.out.println(in);
				Elements li = in.select("div.spots-contents");
				System.out.println(li.size());
				for (Element e : li) {
					Elements a=e.select("a");
					String href=a.attr("href");
					String detail=e.select("a.spot-cat3-item").text();
					String title=e.select("h4.spot-name").text();
//					System.out.println(title);
//					System.out.println(detail);
					
					Connection.Response response02 = Jsoup.connect("https://www.wishbeen.co.kr"+href)
							.method(Connection.Method.GET).execute();
					Document Document02 = response02.parse();
					Elements imgtemp=Document02.select("div>img");
					String img=imgtemp.select("img.carousel-image").attr("src");

				System.out.println(img);

//				bw.write(title + "!놀거리!" + detail + "!"  + "!" + "!" + "!!!" + img);
//				bw.newLine();
				}
				
				no++;

			}
			bw.close();
	}
}
