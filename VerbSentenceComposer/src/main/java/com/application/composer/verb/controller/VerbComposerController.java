package com.application.composer.verb.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "properties")
public class VerbComposerController {

	private String verbs;

	@GetMapping(path = "/verb", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public String getVerb() {
		String[] verbsArray = verbs.split("-");
		int i = (int) Math.round(Math.random() * (verbsArray.length - 1));
		return verbsArray[i];
	}

	public String getVerbs() {
		return verbs;
	}

	public void setVerbs(String verbs) {
		this.verbs = verbs;
	}
}
