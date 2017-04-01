package com.application.composer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.composer.dao.SentenceComposerRepository;
import com.application.composer.util.Constants;

@Service
public class SentenceComposeImpl implements SentenceComposer {

	private SentenceComposerRepository sentenceComposerRepository;
	
	@Autowired
	public SentenceComposeImpl(SentenceComposerRepository sentenceComposerRepository) {
		this.sentenceComposerRepository = sentenceComposerRepository;
	}
	
	@Override
	public String buildSentence() {
		StringBuilder sb = new StringBuilder(100);
		
		sb.append(sentenceComposerRepository.getSubject())
		  .append(Constants.EMPTY_SPACE_SEPARATOR)
		  .append(sentenceComposerRepository.getVerb())
		  .append(Constants.EMPTY_SPACE_SEPARATOR)
		  .append(sentenceComposerRepository.getArticle())
		  .append(Constants.EMPTY_SPACE_SEPARATOR)
		  .append(sentenceComposerRepository.getAdjective())
		  .append(Constants.EMPTY_SPACE_SEPARATOR)
		  .append(sentenceComposerRepository.getNoun())
		  .append(".");
		
		return sb.toString();
	}
	
}
