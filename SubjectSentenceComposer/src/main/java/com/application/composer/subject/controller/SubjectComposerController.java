package com.application.composer.subject.controller;

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
public class SubjectComposerController {

	private String subjects;

	@GetMapping(value = "/subject", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public String getSubject() {
		String[] subjectsArray = subjects.split("-");
		int i = (int) Math.round(Math.random() * (subjectsArray.length - 1));
		return subjectsArray[i];
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
}
