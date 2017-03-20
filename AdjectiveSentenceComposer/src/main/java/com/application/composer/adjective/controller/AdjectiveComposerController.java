package com.application.composer.adjective.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class AdjectiveComposerController {

	@Value(value = "${adjectives}")
	private String adjectives;

	@GetMapping("/")
	public @ResponseBody String getAdjective() {
		String[] adjectiveArray = adjectives.split("-");
		int i = (int) Math.round(Math.random() * (adjectiveArray.length - 1));
		return adjectiveArray[i];
	}
}
