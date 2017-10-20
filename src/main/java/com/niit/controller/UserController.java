package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/")
	public String showIndexPage(){
		System.out.println("Redirecting to index page");
		return "index";
	}

}
