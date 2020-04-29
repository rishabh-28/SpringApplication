package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageService {

	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	@GetMapping("/add")
	public int add() {
		return 40+10;
	}
	@GetMapping("/multiply")
	public int multiply() {
		return 40*10;
	}
	@GetMapping("/subtract")
	public int subtract() {
		return 40 - 10;
	}
	@GetMapping("/try")
	public String sayTry() {
		return "Try";
	}
	@GetMapping("/error")
	public String sayError() {
		return "Error";}
	@GetMapping("/maven")
	public String sayMaven() {
		return "Maven";}
	@GetMapping("/jenkins")
	public String sayJenkins() {
		return "Jenkins";}
	@GetMapping("/AWS")
	public String sayAWS() {
		return "AWS";}
	@GetMapping("/spring")
	public String saySpring() {
		return "Spring";
	}
}
