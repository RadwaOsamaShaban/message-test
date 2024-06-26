package com.example.message.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EnableConfigurationProperties
public class MessageTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageTestApplication.class, args);
	}
}
