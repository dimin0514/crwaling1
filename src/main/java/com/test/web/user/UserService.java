package com.test.web.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.web.pxy.Proxy;


@Component
public class UserService extends Proxy{
	@Autowired UserMapper userMapper;
	
	public String selectAll() {
		List<User> list = userMapper.selectAll();
		
		userMapper.selectAll().forEach(System.out::println);
		
		List<String> ls2 = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			ls2.add(list.get(i).getUid());
		}
		Stream.of(ls2).sorted().forEach(System.out::println);
		
		return objectToString("5");
	}
	
	public String test() {
//		Arrays.asList(1,2,3,4,5).forEach(System.out::print);             
//		Arrays.asList(1,2,3,4,5).stream().forEach(System.out::print); //이건 forEach 돌면 없어짐? 그리고 1~5 담기는건 sysout 에서 프린트 할때 만들어짐 이게 lazy임! 맨 마지막 ; 있을때 움직임
		// 1,2,3,4,5가 sysout 찍고 나면 없어짐.. stream 개울가 물 흘러감 끝남. 메모리에 흔적도 안남기고 깨끗하게 사라짐. 전 화면의 잔상도 없는... 스트리밍에서 찍자마자 사라지게... 
		//이제 자바코드에 for 와 if 안쓰고 만들어야 함!
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();
		 
		
//		intStream.forEach(System.out::print);
		
//		for(int i=0;i<5;i++) {
//			System.out.println(i);
//		}
		
//		IntStream.range(100,200).forEach(System.out::print);
//		IntStream.rangeClosed(100, 200).forEach(System.out::print);
		
		
		new Random().ints().limit(5).forEach(System.out::print);
	
		return objectToString("5");
	}

}
