package com.atlandes.productCode.common;
//
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

//@ContextConfiguration(locations="classpath*:/spring/spring-content.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-content.xml")
public class  BaseConfig  {

}
