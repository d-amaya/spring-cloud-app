package com.application.composer.article.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("192.168.99.100");
		connectionFactory.setUsername("rabbit");
		connectionFactory.setPassword("rabbit");
		connectionFactory.setVirtualHost("microservices.vh");
		return connectionFactory;
	}
}
