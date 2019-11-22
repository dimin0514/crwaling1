package com.test.web.aop;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.pxy.Box;



@RestController
@RequestMapping("/tx")
@Transactional
public class TxController {
	@Autowired TxService txService;
	@Autowired Box<String> trunk;
//	@Autowired CrawlingProxy crawler;
	@Autowired Box<String> box;
	
//	//크롤링
//	@GetMapping("/crawling/{site}/{srch}")
//	public void bringUrl(@PathVariable String site, @PathVariable String srch) {
//		System.out.println(site +", srch" + srch);
//		trunk.accept(Arrays.asList("site", "srch"), Arrays.asList(site, srch));
//		 box = txService.crawling(trunk.get());
//	}
	//유저 정보 입력
//	@GetMapping("/register/users")
//	public Map<?,?> registerUsers() {
//		int userCount = txService.registerUsers();
//		System.out.println("서비스 카운팅 :::" + userCount);
//		trunk.accept(Arrays.asList("userCount"), Arrays.asList(crawler.string(userCount)));
//		return trunk.get();
//	}
//	//게시판 정보 입력
//	@GetMapping("/write/info")
//	public Map<?,?> writeArticles() {
//		System.out.println("게시판 글 입력 들어옴");
//		int articleCount = txService.writeArticles();
//		System.out.println("서비스 카운팅 :::" + articleCount);
//		trunk.accept(Arrays.asList("articleCount"), Arrays.asList(crawler.string(articleCount)));
//		return trunk.get();
//	}
//	//고양이 정보 입력 
//	@GetMapping("/register/cats")
//	public Map<?,?> registerCats() {
//		System.out.println("고양이 정보 입력 들어옴");
//		int catCount = txService.registerCats();
//		System.out.println("서비스 카운팅 :::" + catCount);
//		trunk.accept(Arrays.asList("catCount"), Arrays.asList(crawler.string(catCount)));
//		return trunk.get();
//	}
//	//강아지 정보 입력
//	@GetMapping("/register/dogs")
//	public Map<?,?> registerDogs() {
//		System.out.println("강이지 정보 입력 들어옴");
//		int dogCount = txService.registerDogs();
//		System.out.println("서비스 카운팅 :::" + dogCount);
//		trunk.accept(Arrays.asList("dogCount"), Arrays.asList(crawler.string(dogCount)));
//		return trunk.get();
//	}
	//유저 테이블 정보 삭제 
//	@GetMapping("/truncate/users")
//	public Map<?,?> truncateUsers() {
//		int userCount = txService.trucateUser();
//		System.out.println("서비스 카운팅 :"+userCount);
//		trunk.accept(Arrays.asList("userCount"),Arrays.asList(crawler.string(userCount)));
//		return trunk.get();
//	}

}