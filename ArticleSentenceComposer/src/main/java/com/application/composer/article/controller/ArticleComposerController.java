package com.application.composer.article.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ArticleComposerController {

	@Value(value = "${articles}")
	private String articles;

	@GetMapping("/")
	public @ResponseBody String getArticle() {
		String[] articleArray = articles.split("-");
		int i = (int) Math.round(Math.random() * (articleArray.length - 1));
		return articleArray[i];
	}
}
