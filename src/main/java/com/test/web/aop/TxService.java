package com.test.web.aop;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.mypet.web.brd.ArticleMapper;
//import com.mypet.web.cat.CatMapper;
//import com.mypet.web.dog.DogMapper;
//import com.mypet.web.pxy.ArticleProxy;
//import com.mypet.web.pxy.Box;
//import com.mypet.web.pxy.CatProxy;
//import com.mypet.web.pxy.CrawlingProxy;
//import com.mypet.web.pxy.DogProxy;
//import com.mypet.web.pxy.UserProxy;
//import com.mypet.web.usr.User;
//import com.mypet.web.usr.UserMapper;

//@Transactional 비추 클래스에 다 걸어버리면 트랜젝션을 안사용하는것도 걸리기 떄문에 느려진다 그래서 사용하는 것만 어노테이션 붙여준다.
@Service
public class TxService {
	 //프록시 사무실
//	@Autowired Printer printer;
//	@Autowired UserMapper userMapper;
//	@Autowired TxMapper txMapper;
//	@Autowired CrawlingProxy crawler;
//	@Autowired UserProxy manager;
//	@Autowired Box<String> box;
//	@Autowired ArticleProxy comm;
//	@Autowired ArticleMapper articleMapper;
//	@Autowired CatProxy catProxy;
//	@Autowired CatMapper catMapper;
//	@Autowired DogProxy dogProxy;
//	@Autowired DogMapper dogMapper;

	
//	@SuppressWarnings("unchecked")//노란불 뜨면 그냥 잡아서 실행하면 됨
//	public Box<String> crawling(Map<?,?> paramMap){
////		List<String> txServiceList = new ArrayList<>();
//////		printer.accept("tx서비스 들어옴");
////		txServiceList.clear(); 
////		txServiceList = (List<String>) crawler.choose(paramMap);
////		return txServiceList;\
//		return crawler.choose(paramMap);
//	}
//	@Transactional
//	public int writeArticles() {
//		comm.insertArticles();
//		return articleMapper.countArticles();
//	}
//	
//	@Transactional
//	public int registerUsers(){
//		manager.insertUsers();
//		return userMapper.countUsers();
//	}
//	@Transactional
//	public int registerCats() {
//		catProxy.insertCats();
//		return catMapper.countCats();
//	}
//	@Transactional
//	public int registerDogs() {
//		dogProxy.insertDogs();
//		return dogMapper.countDogs();
//	}
//	public int trucateUser() {
//		manager.truncateUsers();
//		return userMapper.countUsers();
//	}
}