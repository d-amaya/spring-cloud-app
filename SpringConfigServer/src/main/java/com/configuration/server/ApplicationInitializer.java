package com.configuration.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;

import com.configuration.server.config.AmqpConfig;

@SpringBootApplication
@EnableConfigServer
@Import(value = {AmqpConfig.class})
public class ApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationInitializer.class, args);
	}
}
