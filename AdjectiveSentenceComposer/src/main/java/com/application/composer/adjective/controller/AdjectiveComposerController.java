package com.application.composer.adjective.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@ConfigurationProperties(prefix = "properties")
public class AdjectiveComposerController {

	private String adjectives;

	@GetMapping(value = "/adjective", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public String getAdjective() {
		String[] adjectiveArray = adjectives.split("-");
		int i = (int) Math.round(Math.random() * (adjectiveArray.length - 1));
		return adjectiveArray[i];
	}

	public String getAdjectives() {
		return adjectives;
	}

	public void setAdjectives(String adjectives) {
		this.adjectives = adjectives;
	}
}
