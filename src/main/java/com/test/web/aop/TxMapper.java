package com.test.web.aop;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

//import com.mypet.web.brd.Articles;
//import com.mypet.web.cat.Cat;
//import com.mypet.web.dog.Dog;
import com.test.web.user.User;
@Repository
public interface TxMapper {
	@Insert("INSERT INTO USER (UID,PWD,SSN,UNAME,PHONE,ADDRESS,EMAIL,PETTYPE)values(" + 
			"#{uid}, #{pwd},#{ssn},#{uname},#{phone},#{address},#{email},#{petType})")
	public void insertUser(User param);

//	@Insert("INSERT INTO ARTICLES (IMAGE,UID,COMMENTS,MSG,RATING,CATEGORY,HASHTAG,CONTENT)values(" + 
//			"#{image}, #{uid},#{comments},#{msg},#{rating},#{category},#{hashtag},#{content})")
//	public void insertArticle(Articles param);
//
//	@Insert("INSERT INTO CAT(BIRTH,SEX,NAME,HAIRLENGTH,HAIRCOLOR,SPECIES,SIZE,STYLE,ILLHISTORY)values(" + 
//			"#{birth}, #{sex},#{name},#{hairlength},#{haircolor},#{species},#{size},#{style},#{illhistory})")
//	public void insertCats(Cat param);
//
//	@Insert("INSERT INTO DOG (SPECIES,SIZE,NAME,HAIRLENGTH,COLOR,SEX,BREED,AGE,BIRTHDATE,VACCIN)values(" + 
//			"#{species}, #{size},#{name},#{hairLength},#{color},#{sex},#{breed},#{age},#{birthdate},#{vaccin})")
//	public void insertDogs(Dog param);
}