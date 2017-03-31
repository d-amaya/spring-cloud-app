package com.application.composer.subject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class SubjectComposerController {

	@Value(value = "${subjects}")
	private String subjects;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public String getSubject() {
		String[] subjectsArray = subjects.split("-");
		int i = (int) Math.round(Math.random() * (subjectsArray.length - 1));
		return subjectsArray[i];
	}
}
