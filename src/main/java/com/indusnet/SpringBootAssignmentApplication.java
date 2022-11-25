package com.indusnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringBootAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentApplication.class, args);
	}

	
@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
