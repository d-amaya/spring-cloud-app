package com.springboot.microservices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(path="/")
	public String getIndexPage() {
		return "index" ;
	}
}
