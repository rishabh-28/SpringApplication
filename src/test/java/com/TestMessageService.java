package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.MessageService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestMessageService {

	@Test
	public void testMessage() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.sayHello(), "hello");
	}
	@Test
	public void testAdd() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.add(), 50);
	}
	@Test
	public void testSubtract() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.subtract(), 30);
	}
	@Test
	public void testMultiply() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.multiply(), 400);
	}
	
	@Test
	public void testTry() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.sayTry(), "Try");
	}
	@Test
	public void testJenkins() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.sayJenkins(), "Jenkins");
	}
	@Test
	public void testAWS() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.sayAWS(), "AWS");
	}
	@Test
	public void testError() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.sayError(), "Error");
	}
	@Test
	public void testSpring() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.saySpring(), "Spring");
	}
	@Test
	public void testMaven() {
		MessageService ms = new MessageService();
		Assertions.assertEquals(ms.sayMaven(), "Maven");
	}
	
}