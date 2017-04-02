package com.application.composer.noun.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "properties")
public class NounComposerController {

	private String nouns;

	@GetMapping(value = "/noun", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String getNoun() {
		String[] nounArray = nouns.split("-");
		int i = (int) Math.round(Math.random() * (nounArray.length - 1));
		return nounArray[i];
	}

	public String getNouns() {
		return nouns;
	}

	public void setNouns(String nouns) {
		this.nouns = nouns;
	}
}
