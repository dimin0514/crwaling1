package com.test.web.pxy;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Inventory<T> {
	private ArrayList<T> inventory; //일단 list 프라이빗으로 만들고
	
	public Inventory() {
		inventory = new ArrayList<>();
	}
	public void add(T t) {
//		list = new ArrayList<>(); 셍성자 만들어서 만들면 알아서 들어감?
		inventory.add(t);
	}// list의 세터 만들기 T t 가 들어감 , 제네릭 만들어서 회사에서 그냥 써먹어도됨 뭐라안함
	
	public void clear() {
		inventory.clear();
	}
	public T get(int i) {
		return inventory.get(i);
	}
	public ArrayList<T> get(){
		return inventory;
	}

}
