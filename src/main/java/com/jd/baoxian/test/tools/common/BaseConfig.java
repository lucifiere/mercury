package com.jd.baoxian.test.tools.common;
//
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

//@ContextConfiguration(locations="classpath*:/spring/spring-content.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/WEB-INF/jsf-consumer.xml")
public class  BaseConfig  {

}