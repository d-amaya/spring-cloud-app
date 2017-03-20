package com.application.composer.noun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NounComposerController {

	@Value(value = "${nouns}")
	private String nouns;

	@GetMapping("/")
	public @ResponseBody String getNoun() {
		String[] nounArray = nouns.split("-");
		int i = (int) Math.round(Math.random() * (nounArray.length - 1));
		return nounArray[i];
	}
}
