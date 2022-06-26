package com.blindeyestudios.supervisornotification;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.util.Arrays;

@SpringBootApplication
public class SupervisorNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupervisorNotificationApplication.class, args);
	}

}
