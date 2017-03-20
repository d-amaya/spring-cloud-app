package com.application.composer.verb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class VerbComposerController {

	@Value(value = "${verbs}")
	private String verbs;

	@GetMapping("/")
	public @ResponseBody String getVerb() {
		String[] verbsArray = verbs.split("-");
		int i = (int) Math.round(Math.random() * (verbsArray.length - 1));
		return verbsArray[i];
	}
}
