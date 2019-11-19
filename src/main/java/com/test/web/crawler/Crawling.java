package com.test.web.crawler;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.pxy.CrwalingProxy;
import com.test.web.pxy.Inventory;

@RestController
@RequestMapping("/")
public class Crawling {
	@Autowired CrwalingProxy crwal;
	
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> crwalingNaver() {
//		
//		System.out.println("네이버 들어옴: "+crwal.engCrawling().get(0).get("origin"));
		return crwal.engCrawling("https://endic.naver.com/?sLn=kr");  //list 던지면 js 에서 $.each 로 받음.
	}
	
	@GetMapping("/bugs")
	public void crwalingBugs() {
		System.out.println("벅스 들어옴");
	}
	
	@GetMapping("/cgv")
	public ArrayList<HashMap<String, String>> crwalingCgv() {
		System.out.println("cgv 들어옴");
		
		return crwal.cgvCrawl();
	}

}
