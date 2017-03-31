package com.application.composer.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.application.composer.util.Constants;

@RestController
@RequestMapping(value = "/ribbon")
public class SentenceComposerRibbonController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping(value = "/sentence")
	public @ResponseBody String getSentence() {
		return getWord(Constants.SUBJECT_SERVICE_NAME) 
				+ " " + getWord(Constants.VERB_SERVICE_NAME) 
				+ " " + getWord(Constants.ARTICLE_SERVICE_NAME) 
				+ " " + getWord(Constants.ADJECTIVE_SERVICE_NAME) 
				+ " " + getWord(Constants.NOUN_SERVICE_NAME) + ".";
	}

	public String getWord(String serviceName) {
		ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
		URI uri = serviceInstance.getUri();
		if (uri != null) {
			return (new RestTemplate()).getForObject(uri, String.class);
		}
		return null;
	}
}
