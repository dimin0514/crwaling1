package com.test.web.pxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;




@Component("crwaler") //상속을 걸면 이름을 줘라..
@Lazy
public class CrwalingProxy extends Proxy {
	@Autowired Inventory<HashMap<String, String>> inventory;
	@Autowired Box<String> box; //크롤링이니깐 스트링으로 받을것. 이녀석이 bean DTO 역할을 함
	
	public ArrayList<HashMap<String, String>> engCrawling(String url) {
		url="https://endic.naver.com/?sLn=kr";
		inventory.clear();
		try {
			Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
			Elements txtOrigin = rawData.select("div[class=\"txt_origin\"] a");
			//txt_trans
			Elements txtTrans = rawData.select("div[class=\"txt_trans\"]");
			HashMap<String, String> map = null;
			for (int i=0;i<txtOrigin.size();i++) {
				map = new HashMap<>();
				map.put("origin", txtOrigin.get(i).text());
				map.put("trans",txtTrans.get(i).text());
				inventory.add(map);

			}
//			System.out.println("inventory에 담긴: " + inventory);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("============크롤링 결과================");
//		inventory.get().forEach(System.out::println);       //이게 중요함.메서드를 참조변수로 만들어서 파라미터로 넣을 수 있음! 달리다(동사)-> 달리기(명사)
		return inventory.get();
	}
	
	public ArrayList<HashMap<String, String>> cgvCrawl() {
		// private String cgvseq, title, content, img;
		inventory.clear();

		try {
			final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
			String bugs = "http://www.cgv.co.kr/movies/";
			Connection.Response homePage;
			homePage = Jsoup.connect(bugs).method(Connection.Method.GET).userAgent(USER_AGENT)
					.execute();
			Document temp = homePage.parse();
			Elements element = temp.select("div.sect-movie-chart");
			Elements tempforTitle = element.select("strong.title");
			Elements tempforPrecent = element.select("strong.percent");
			Elements tempforTextinfo = element.select("span.txt-info");
			Elements tempforphoto = temp.select("span.thumb-image");
			
			HashMap<String, String> map = null;
			for (int i=0;i<tempforTitle.size();i++) {
				map = new HashMap<>();
				map.put("title",tempforTitle.get(i).text());
				map.put("percent",tempforPrecent.get(i).text());
				map.put("info",tempforTextinfo.get(i).text());
				map.put("photo",tempforphoto.get(i).select("img").attr("src"));
				inventory.add(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("============크롤링 결과================");
		inventory.get().forEach(System.out::println);       //이게 중요함.메서드를 참조변수로 만들어서 파라미터로 넣을 수 있음! 달리다(동사)-> 달리기(명사)
		return inventory.get();
	}

}
