package com.application.composer.dao.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.composer.util.Constants;

@FeignClient(name = Constants.ADJECTIVE_SERVICE_NAME, path = "/api")
public interface AdjectiveSentenceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/adjective", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAdjective();
}
