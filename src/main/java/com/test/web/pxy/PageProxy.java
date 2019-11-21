package com.test.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Lazy
@Component("pager")
public class PageProxy extends Proxy {
	@Autowired CrwalingProxy crwaler;  //여기서 이름은 컴퍼넌트에 정해진 이름 써야함
	
	private int rowCount, startRow, endRow,
				pageSize,pageCount,startPage,endPage,nowPage, //endpage는 블락의 엔드페이지?
				blockSize,blockCount,prevBlock,nextBlock,nowBlock;
	private boolean existPrev, existNext;
	private String search;
	
	public void paging() {
//		int rowCount = 0; 내부에서 하는게 아니라 외부에서 주입받아야 겠다. 페이징을 재활용해서 써야하니깐. 컨트롤러에서 받아서 쓰게 해야함! 롬북으로 게터세터 만들었기때문에 set 해서 이미 넣어놓은것  rowCount,pageSize,startPage
		print("크롤링 사이즈"+rowCount); //바로 syso 즉 만들어놓은 프린트 됨. 이맛에 상속을 씀!
//		pageSize = 5; //외부에서 줄수 있게 해야 하는데 일단은 간단하게...  컨트롤러에서 셋해서 받았음
//		blockSize = 5; //외부에서 줄수 있게 해야 하는데 일단은 간단하게 ...  컨트롤러에서 셋해서 받았음
//		pageCount= rowCount/pageSize;   //여기까지가 산수고 101 이런식으로 딱 떨어지지 않았을때를 산정해서 삼항연산자로 해야함.
		pageCount= (rowCount % pageSize!=0)? rowCount/pageSize+1: rowCount/pageSize;
		blockCount= (pageCount % blockSize!=0)? pageCount/blockSize+1:pageCount/blockSize; //디멘션이 한차원 올라갔을뿐 앞의것 반복!
		startRow = nowPage*pageSize;  //nowPage 가 1이면 1~5 니깐 1, 2면 6~10 6임
//		endRow = (nowPage!=pageCount)?nowPage*pageSize-1:rowCount-1; 내생각
		endRow = (nowPage!=pageCount-1)?startRow+(pageSize-1):rowCount-1; 
		
		//
		nowBlock=nowPage/blockSize;
		
		startPage = nowBlock * blockSize;
		endPage = (nowBlock != (blockCount - 1)) ? startPage + (blockSize-1) : pageCount - 1;
		
		prevBlock = startPage - blockSize;
		nextBlock = startPage + blockSize;
		existPrev = nowBlock != 0;
		existNext = nowBlock != blockCount-1; 
		
//		강사님 한것과 비교 기억!		
//		pageCount = (rowCount % pageSize != 0) ? rowCount / pageSize + 1: rowCount / pageSize;
//		blockCount = (pageCount % blockSize != 0) ? pageCount / blockSize + 1: pageCount / blockSize;
//		startRow = nowPage * pageSize;
//		endRow = (nowPage != (pageCount - 1)) ? startRow + (pageSize-1) : rowCount - 1;
//		nowBlock = nowPage / blockSize;
//		startPage = nowBlock * blockSize;
//		endPage = (nowBlock != (blockCount - 1)) ? startPage + (blockSize-1) : pageCount - 1;
//		prevBlock = startPage - blockSize;
//		nextBlock = startPage + blockSize;
//		existPrev = nowBlock != 0;
//		existNext = (nowBlock+1) != blockCount; 
	
	}

}
