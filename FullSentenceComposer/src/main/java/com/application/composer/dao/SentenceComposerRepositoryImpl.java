package com.application.composer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.composer.dao.clients.AdjectiveSentenceClient;
import com.application.composer.dao.clients.ArticleSentenceClient;
import com.application.composer.dao.clients.NounSentenceClient;
import com.application.composer.dao.clients.SubjectSentenceClient;
import com.application.composer.dao.clients.VerbSentenceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Repository
public class SentenceComposerRepositoryImpl implements SentenceComposerRepository {

	private SubjectSentenceClient subjectSentenceClient;
	private VerbSentenceClient verbSentenceClient;
	private ArticleSentenceClient articleSentenceClient;
	private AdjectiveSentenceClient adjectiveSentenceClient;
	private NounSentenceClient nounSentenceClient; 
	
	@Autowired
	public SentenceComposerRepositoryImpl(SubjectSentenceClient subjectSentenceClient,
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
	
	@Override
	@HystrixCommand(fallbackMethod = "getSubjectFallback")
	public String getSubject() {
		return subjectSentenceClient.getSubject();
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getVerbFallback")
	public String getVerb() {
		return verbSentenceClient.getVerb();
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getArticleFallback")
	public String getArticle() {
		return articleSentenceClient.getArticle();
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getAdjectiveFallback")
	public String getAdjective() {
		return adjectiveSentenceClient.getAdjective();
	}
	
	@Override
	@HystrixCommand(fallbackMethod = "getNounFallback")
	public String getNoun() {
		return nounSentenceClient.getNoun();
	}
	
	@SuppressWarnings("unused")
	private String getSubjectFallback() {
		return "Someone";
	}
	
	@SuppressWarnings("unused")
	private String getVerbFallback() {
		return "did";
	}
	
	@SuppressWarnings("unused")
	private String getArticleFallback() {
		return "a";
	}
	
	@SuppressWarnings("unused")
	private String getAdjectiveFallback() {
		return "";
	}
	
	@SuppressWarnings("unused")
	private String getNounFallback() {
		return "thing";
	}
}
