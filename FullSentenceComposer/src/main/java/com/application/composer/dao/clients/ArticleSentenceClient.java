package com.application.composer.dao.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.composer.util.Constants;

@FeignClient(name = Constants.ARTICLE_SERVICE_NAME, path = "/api")
public interface ArticleSentenceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/article", produces = MediaType.APPLICATION_JSON_VALUE)
	public  String getArticle();
}
