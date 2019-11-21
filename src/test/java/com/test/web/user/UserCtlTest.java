package com.test.web.user;

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
public class UserCtlTest {
	@Autowired UserCtl userctl;
	

	@Test
	public void testRowCount() {
		assertThat(userctl.rowCount(), is(equalTo(0)));
	}

}
