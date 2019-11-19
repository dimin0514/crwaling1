package com.test.web.pxy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("pxy")  //이름을 Proxy로 하면 pxy라고 안줘도 된다.
@Lazy
public class Proxy {
	public String objectToString(Object param) {
		Function<Object, String> f = s-> String.valueOf(s);
		return f.apply(param);
	}
	
	
	public int integer(String param) {
		Function<String,Integer> f = Integer::parseInt;
		return f.apply(param);
		
	}
	public boolean equal(String t,String u) {
		BiPredicate<String, String> f = String:: equals;
		
		return f.test(t, u);
	}
	
	public void print(String t) {
		Consumer<String> c = System.out::print; //익스프레션 타입은? Consumer 타입을 가진다는 것은 객체! 얘는 객체임. 객체니깐 파라미터로 전달가능!
		//우리가 알고 있는 syso 은 메서드지만 객체로 변경해서 참조변수로 파리마터값으로 넣을수 있다. 
		
		c.accept(t);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int parseInt(String param) {
//		Function<String, Integer> f = s -> Integer.parseInt(s);
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	public boolean equals(String p1,String p2) {
		BiFunction<String, String, Boolean> f = String :: equals;
		return f.apply(p1, p2);
	}
	public int random(int a,int b) {
		BiFunction<Integer, Integer, Integer> f = (t,u) ->(int)(Math.random()*(u-t)+t) ;
		return f.apply(a,b);
	}
	public int[] intArray(int size) {
		Function<Integer, int[]> f = int[] :: new;
		
		return f.apply(size); 
	}
	public String currentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public String currentTime() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	}
	
	//new로 하려니깐 보기 싫어서 이렇게 프록시 만들었는데 이거 보니깐 지네릭으로 할 수 있겠네?
	
}
