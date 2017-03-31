package com.application.composer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.composer.dao.AdjectiveSentenceClient;
import com.application.composer.dao.ArticleSentenceClient;
import com.application.composer.dao.NounSentenceClient;
import com.application.composer.dao.SubjectSentenceClient;
import com.application.composer.dao.VerbSentenceClient;

@RestController
public class SentenceComposerFeignController {
	
	private static final String EMPTY_SPACE_SEPARATOR = " ";

	private SubjectSentenceClient subjectSentenceClient;
	private VerbSentenceClient verbSentenceClient;
	private ArticleSentenceClient articleSentenceClient;
	private AdjectiveSentenceClient adjectiveSentenceClient;
	private NounSentenceClient nounSentenceClient;
	
	@Autowired
	public SentenceComposerFeignController (SubjectSentenceClient subjectSentenceClient,
			VerbSentenceClient verbSentenceClient,
			ArticleSentenceClient articleSentenceClient,
			AdjectiveSentenceClient adjectiveSentenceClient,
			NounSentenceClient nounSentenceClient) {
		
		this.subjectSentenceClient = subjectSentenceClient;
		this.verbSentenceClient = verbSentenceClient;
		this.articleSentenceClient = articleSentenceClient;
		this.adjectiveSentenceClient = adjectiveSentenceClient;
		this.nounSentenceClient = nounSentenceClient;
	}
	
	@GetMapping(value = "/sentence")
	public @ResponseBody String getSentence() {
		return subjectSentenceClient.getSubject()
				+ EMPTY_SPACE_SEPARATOR + verbSentenceClient.getVerb()
				+ EMPTY_SPACE_SEPARATOR + articleSentenceClient.getArticle()
				+ EMPTY_SPACE_SEPARATOR + adjectiveSentenceClient.getAdjective()
				+ EMPTY_SPACE_SEPARATOR + nounSentenceClient.getNoun() + ".";
	}
}
