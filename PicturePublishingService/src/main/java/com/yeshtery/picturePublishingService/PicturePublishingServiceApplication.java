package com.yeshtery.picturePublishingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebSecurity
@EnableSwagger2
public class PicturePublishingServiceApplication {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(PicturePublishingServiceApplication.class, args);
	}

}
