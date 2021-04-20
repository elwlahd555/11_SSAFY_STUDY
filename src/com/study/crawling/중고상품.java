package com.study.crawling;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class 중고상품 {
    public static void main(String[] args) throws Exception {

        Connection.Response response = Jsoup
                .connect("https://m.bunjang.co.kr/search/products?q=%EB%B2%84%EC%A6%88")
                .method(Connection.Method.GET).execute();
        Document Document = response.parse();
        Elements temp=Document.select("img");
        System.out.println(Document);

    }

}
