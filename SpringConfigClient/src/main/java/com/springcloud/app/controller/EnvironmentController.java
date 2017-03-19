package com.springcloud.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvironmentController {

	@Value(value = "${lucky-word}")
	private String luckyWord;

	@GetMapping("/lucky-word")
	public String showLuckyWord() {
		return "The lucky-word property is: " + luckyWord;
	}
}
