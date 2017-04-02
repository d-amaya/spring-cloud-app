package com.application.composer.article.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "properties")
public class ArticleComposerController {

	private String articles;

	@GetMapping(value = "/article", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	public String getArticle() {
		String[] articleArray = articles.split("-");
		int i = (int) Math.round(Math.random() * (articleArray.length - 1));
		return articleArray[i];
	}

	public String getArticles() {
		return articles;
	}

	public void setArticles(String articles) {
		this.articles = articles;
	}
}
