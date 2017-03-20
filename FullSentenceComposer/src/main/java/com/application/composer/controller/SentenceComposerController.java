package com.application.composer.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.composer.util.Constants;

@RestController
public class SentenceComposerController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord(Constants.SUBJECT_SERVICE_NAME) 
				+ " " + getWord(Constants.VERB_SERVICE_NAME) 
				+ " " + getWord(Constants.ARTICLE_SERVICE_NAME) 
				+ " " + getWord(Constants.ADJECTIVE_SERVICE_NAME) 
				+ " " + getWord(Constants.NOUN_SERVICE_NAME) + ".";
	}

	public String getWord(String serviceName) {
		List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
		if (list != null && list.size() > 0) {
			URI uri = list.get(0).getUri();
			if (uri != null) {
				return (new RestTemplate()).getForObject(uri, String.class);
			}
		}
		return null;
	}
}
