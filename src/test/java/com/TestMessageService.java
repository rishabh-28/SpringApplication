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
}