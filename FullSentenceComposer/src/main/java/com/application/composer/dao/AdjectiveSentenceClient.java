package com.application.composer.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.composer.util.Constants;

@FeignClient(name = Constants.ADJECTIVE_SERVICE_NAME)
public interface AdjectiveSentenceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getAdjective();
}
