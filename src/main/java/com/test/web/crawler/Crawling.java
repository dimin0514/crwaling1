package com.test.web.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.pxy.Box;
import com.test.web.pxy.CrwalingProxy;
import com.test.web.pxy.Inventory;
import com.test.web.pxy.PageProxy;

@RestController
@RequestMapping("/")
public class Crawling {
	@Autowired CrwalingProxy crwal;
	@Autowired PageProxy pager;
	@Autowired Box<Object> box;
	
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> crwalingNaver() {
//		
//		System.out.println("네이버 들어옴: "+crwal.engCrawling().get(0).get("origin"));
		return crwal.engCrawling("https://endic.naver.com/?sLn=kr");  //list 던지면 js 에서 $.each 로 받음.
	}
	
	@GetMapping("/cgv")
	public ArrayList<HashMap<String, String>> crwalingCgv() {
		System.out.println("cgv 들어옴");
		
		return crwal.cgvCrawl();
	}
	
	@GetMapping("/bugs")
	public Map<?,?> crwalingBugs() {
		System.out.println("벅스 들어옴");
		ArrayList<HashMap<String, String>> list = crwal.bugsCrawling();
		pager.setRowCount(list.size());  // 이미 게터세터 만들었음.
		pager.setPageSize(10);
		pager.setBlockSize(5);
		pager.setNowPage(0);
		pager.paging();
//		int size = list.size();
//		pager.paging(size);
//		int startRow = pager.getStartRow();
//		int pageSize = pager.getPageSize();
		ArrayList<HashMap<String, String>>  temp = new ArrayList<>();
		for(int i=0;i< list.size();i++) {
			if(i>=pager.getStartRow()&& i<= pager.getEndRow()) {
				
				temp.add(list.get(i));
			}
			if(i>pager.getEndRow()) {
				break;
			}
		}
		
		box.put("page", pager);
		box.put("list", temp);
	
		return box.get();
	}
	

}
