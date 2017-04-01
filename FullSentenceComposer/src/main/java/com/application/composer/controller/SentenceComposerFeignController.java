package com.application.composer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.composer.service.SentenceComposer;

@RestController
public class SentenceComposerFeignController {
	
	private SentenceComposer sentenceComposer;
	
	@Autowired
	public SentenceComposerFeignController (SentenceComposer sentenceComposer) {
		this.sentenceComposer = sentenceComposer;
	}
	
	@GetMapping(value = "/sentence")
	public @ResponseBody String getSentence() {
		return sentenceComposer.buildSentence();
	}
}
