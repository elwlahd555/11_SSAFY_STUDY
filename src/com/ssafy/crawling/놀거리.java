package com.ssafy.crawling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 놀거리 {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\ssafy\\test04.txt");

		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(file));
		int no = 1;
		while (no <= 3) {

			Connection.Response response = Jsoup.connect(
					"https://www.wishbeen.co.kr/city?serviceType=daegu&tab=attraction&cat2=001f2309b8ef4a82&viewPageNum="
							+ no + "&perPage=100")
					.method(Connection.Method.GET).execute();
			Document Document = response.parse();

			Elements in = Document.select("div.inner-box");
			Elements li = in.select("div.spots-contents");
			System.out.println(li.size());
			for (Element e : li) {
				Elements a=e.select("a");
				String href=a.attr("href");
				String detail=e.select("a.spot-cat3-item").text();
				String title=e.select("h4.spot-name").text();
				System.out.println(title);
				System.out.println(detail);
				
				Connection.Response response02 = Jsoup.connect("https://www.wishbeen.co.kr"+href)
						.method(Connection.Method.GET).execute();
				Document Document02 = response02.parse();
				Elements imgtemp=Document02.select("div>img");
				String img=imgtemp.select("img.carousel-image").attr("src");
//				Elements rightmenu=Document02.select("div.right-menu");
//			System.out.println(rightmenu);
			System.out.println(img);
//			Elements temp = e.select("div.gridInfo");
//
//			Elements title = temp.select("span>a");
//			System.out.println(title.text());
//
//			Elements score = e.select("span.starNum");
//			System.out.println(score.text());
//
//			String href = e.select("a").attr("href");
//
//			Connection.Response response02 = Jsoup.connect("https://www.siksinhot.com" + href)
//					.method(Connection.Method.GET).execute();
//			Document Document02 = response02.parse();
//
//			Elements imgtemp = Document02.select("div.slick-list");
//			Element img = imgtemp.select("img").get(0);
//			System.out.println(img.attr("src"));
//			Elements content = Document02.select("div.content");
//
//			System.out.println("상세조회");
//			Elements detail = content.select("div.store_info");
//			Elements text = detail.select("div>p");
//
//			System.out.println(text.get(1).text());
//			System.out.println(text.get(3).text());
//			System.out.println(text.select(".txt_adr").text());
//
			bw.write(title + "!관광지!" + detail + "!"  + "!" + "!" + "!!!" + img);
			bw.newLine();
			}
			
			no++;

		}
		bw.close();

	}
}