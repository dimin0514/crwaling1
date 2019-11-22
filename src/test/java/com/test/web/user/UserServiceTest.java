package com.test.web.user;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.web.config.RootConfig;
import com.test.web.config.ServletConfig;
import com.test.web.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {  RootConfig.class, ServletConfig.class,
        WebConfig.class }, loader =  AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class UserServiceTest {
	@Autowired UserService userService;
	
	@Ignore
	public void testTest() {
		assertThat(userService.test(), is(equalTo("11")));
	}
	@Test
	public void testselectAll() {
		assertThat(userService.selectAll(), is(equalTo("5")));
	}

}
