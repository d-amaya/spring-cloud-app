package com.application.composer.noun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.application.composer.noun.config.AmqpConfig;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = {AmqpConfig.class})
public class ApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationInitializer.class, args);
	}
}
