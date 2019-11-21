package com.test.web.pxy;
import static org.junit.Assert.*;
import javax.servlet.ServletContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.mock.web.MockServletContext;
import  org.springframework.test.context.ContextConfiguration;
import  org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import  org.springframework.test.context.web.WebAppConfiguration;
import  org.springframework.test.web.servlet.MockMvc;
import  org.springframework.test.web.servlet.setup.MockMvcBuilders;
import  org.springframework.web.context.WebApplicationContext;
import  org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.test.web.config.RootConfig;
import com.test.web.config.ServletConfig;
import com.test.web.config.WebConfig;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {  RootConfig.class, ServletConfig.class,
        WebConfig.class }, loader =  AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class CalculatorTest {
    @Autowired
    Calculator mock;
    @Test
    public void testSum() {
        assertThat(mock.sum(1, 1),  is(equalTo(2)));
    }
    @Ignore
    public void testSubtract() {
        // assertThat(mock.subtract(1, 1),  equalTo(0));
    }
    @Ignore
    public void testAbsoluteVal() {
        // assertThat(mock.absoluteVal(-1),  equalTo(1));
    }
}