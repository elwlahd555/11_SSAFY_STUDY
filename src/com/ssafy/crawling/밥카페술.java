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
public class 밥카페술 {

   public static void main(String[] args) throws IOException{

//      String filePath = "C:/ssafy/storename.txt";
//      
//      //파일을 읽어오기 위한 FileInputStream 객체 선언
//      
//      
//      //FileInputStream에 읽어올 파일 경로 지정 실시
//
//   String line = "";
//   ArrayList<String> arr=new ArrayList<String>();
//      BufferedReader br;
//      try {
//         br = new BufferedReader(new FileReader(filePath));
//         while((line=br.readLine())!=null) {
//            arr.add(line);
//         }
////           System.out.println(new String(readBuffer,"UTF-8"));
//           
//           //객체 사용을 다한 경우 스트림을 닫아준다
//           br.close(); //스트림 닫기
//           System.out.println(arr.size());
//      } catch (FileNotFoundException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//
//      }
//
//        
        File file = new File("C:\\ssafy\\test03.txt");
        
        BufferedWriter bw;
         bw = new BufferedWriter(new FileWriter(file));
         


        String arr[]= {"대구%20수성구%20", "대구%20중구%20","대구%20남구%20","대구%20서구%20","대구%20북구%20","대구%20동구%20","대구%20달서구%20","대구%20달성군%20"};
//      int no=arr.length-1;
        int no=1;
      while(no<=50) {
         
         Connection.Response response = Jsoup.connect("https://www.siksinhot.com/hot/search/places?keywords=%EB%8C%80%EA%B5%AC%20%EC%88%A0%EC%A7%91&rankHide=Y&nO="+no)
               .method(Connection.Method.GET)
               .execute();
         Document Document = response.parse();
         
//         Elements btnK = Document.select("ul[class=\"list-restaurants\"]");
//         Elements news = btnK.select("div.list-restaurant-item");
         
         
         
//         Elements UL=Document.select("ul[class=\"search_list _items\"]");
//         Elements UL=Document.select("ul>li");
//         System.out.println(UL);
//         Elements li=UL.select("li");
//         System.out.println(li.size());
         
//         System.out.println(Document.select("div>ul>li.place-item"));
//         System.out.println(Document);
         
         
         Elements li=Document.select("div>ul>li.place-item");
         System.out.println(li.size());
         for (Element e : li) {
            System.out.println(no);
//            System.out.println(e.select("div.gridInfo"));
            Elements temp=e.select("div.gridInfo");
            
            
            Elements title=temp.select("span>a");
            System.out.println(title.text());
            
            Elements score=e.select("span.starNum");
            System.out.println(score.text());
            
            
//            System.out.println("https://www.siksinhot.com/");
            String href=e.select("a").attr("href");
//            System.out.println(href);
            
            
            Connection.Response response02 = Jsoup.connect("https://www.siksinhot.com"+href)
                  .method(Connection.Method.GET)
                  .execute();
            Document Document02 = response02.parse();
            
            Elements imgtemp=Document02.select("div.slick-list");
            Element img=imgtemp.select("img").get(0);
            System.out.println(img.attr("src"));
            Elements content=Document02.select("div.content");

               
               System.out.println("상세조회");
               Elements detail=content.select("div.store_info");
               Elements text=detail.select("div>p");
               
               System.out.println(text.get(1).text());
               System.out.println(text.get(3).text());
               System.out.println(text.select(".txt_adr").text());
               
               bw.write(title.text() + ",술," + text.get(1).text() + "," + text.select(".txt_adr").text() + "," + text.get(3).text() + ","
                     + ",,," + img.attr("src") + "," + score.text());
               bw.newLine();

         }

         
         /*망고플레이트 카페, 밥 크롤링*/

//         System.out.println(news.size());
         
//         for(Element e : news){
//            Element imgtemp=e.select("div>img").first();
//            Element title=e.select("h2.title").first();
//            Elements item= e.select("figure[class=\"restaurant-item\"]");
//            Element href=item.select("a").first();
//            String temp=href.attr("href");
//            String img=imgtemp.attr("data-original");
//            
//            
//            
//            Connection.Response response02 = Jsoup.connect("https://www.mangoplate.com"+temp)
//                  .method(Connection.Method.GET)
//                  .execute();
//            Document Document02 = response02.parse();
//            Elements address=Document02.select("div[class=\"Restaurant__InfoItemLabel--RoadAddressText\"]");
//            Elements phone=Document02.select("li>a>div.Restaurant__InfoItemLabel");
//            Element scoretemp=Document02.selectFirst("strong>span");
//            String score="0";
//            
//            if(scoretemp == null) {
//               System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//            }else {
//               
//               score=scoretemp.text();
//            }
//            Elements fooditem=Document02.select("table.info");
//            Element cate=fooditem.select("tr").get(2).select("td").get(0);
//            String price="!";
//            
//            String time="!";
//            if(fooditem.select("tr").size()>=6) {
//               time=fooditem.select("tr").get(5).select("td").get(0).text();
//               price=fooditem.select("tr").get(3).select("td").get(0).text();
//               
//            }else if(fooditem.select("tr").size()>=4){
//               price=fooditem.select("tr").get(3).select("td").get(0).text();
//            }
//
////            Element menu=fooditem.select("tr").get(8).select("td").get(0);
////            System.out.println(e.text());
////            System.out.println(imgtemp);
////            System.out.println(temp);
//            if(cate.text().contains("카페")) {
//               System.out.println(title.text());
////            System.out.println(fooditem.text());
//               System.out.println(cate.text());
////               System.out.println(price.text());
////               System.out.println(time.text());
////            System.out.println(menu.text());
//               System.out.println(img);
//               System.out.println(address.text());
//               System.out.println(phone.text());
////               System.out.println(score.text());
//               
//            }else {
////               System.out.println(title.text());
//////            System.out.println(fooditem.text());
////               System.out.println(cate.text());
////               System.out.println(price.text());
////               System.out.println(time.text());
//////            System.out.println(menu.text());
////               System.out.println(img);
////               System.out.println(address.text());
////               System.out.println(phone.text());
////               System.out.println(score.text());
//               
//            }
//              if(file.isFile()&&file.canWrite()) {
//               if(cate.text().contains("카페")) {
//                  bw.write(title.text()+"!카페!"+cate.text()+"!"+address.text()+"!"+phone.text()+"!"+price+"!"+time+"!!!"+img+"!"+score);
//                  bw.newLine();
//                  
//               }else {
//                  bw.write(title.text()+"!밥!"+cate.text()+"!"+address.text()+"!"+phone.text()+"!"+price+"!"+time+"!!!"+img+"!"+score);
//                  bw.newLine();
//               }
//                 
//              }
//            
//            
//         }
         
         /*대구 술집 크롤링*/
         
//         for (Element e : UL) {
////            System.out.println(e.select("li[id=\"item-356176\"] a").attr("href"));
//            System.out.println(e.select("div>a").attr("href"));
//            
////            System.out.println(e.text());
//         }
         
         no++;
      }
      bw.close();

   }
}