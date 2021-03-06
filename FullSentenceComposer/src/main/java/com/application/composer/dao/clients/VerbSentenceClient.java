package com.application.composer.dao.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.composer.util.Constants;

@FeignClient(name = Constants.VERB_SERVICE_NAME, path = "/api")
public interface VerbSentenceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/verb", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getVerb();
}
